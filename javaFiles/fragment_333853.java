try {
    // Regexp pattern used to strip the links
    Pattern p = Pattern.compile("\'([^\']*)\'");

    // First, let's find the IFRAME from the main page
    Document doc = Jsoup.connect("http://blich.co.il/timetable-shahaf").get();
    Elements iframe = doc.select("iframe");
    if (!iframe.isEmpty()) {
        String src = iframe.get(0).absUrl("src");
        if (!TextUtils.isEmpty(src)) {
            // Now we need to fetch the contents of the IFRAME
            doc = Jsoup.connect(src).get();

            // This is where we manipulate the <select ..> statement. There's only
            // one on this page, so this will be done quick and dirty
            Elements selects = doc.select("select.HeaderClasses");
            Elements options = selects.select("option");
            if (!options.isEmpty()) {
                // There's a lot of options here.. dunno what they mean, so let's just
                // select a **random** and go with that. Your code should probably let the user
                // choose from a dialog or something.
                Collections.shuffle(options);
                Element option = options.get(0);

                String name=selects.get(0).attr("name");
                if (!TextUtils.isEmpty(name)) {
                    doc = Jsoup.connect(src)
                            .data("__EVENTTARGET", name)
                            .data("__EVENTARGUMENT", "")
                            .data(name, option.attr("value")) // Add random option value
                            .data("__VIEWSTATE", 
                                    doc.select("input#__VIEWSTATE").attr("value"))
                            .data("__LASTFOCUS", "")
                            .post();
                }
            }
            // All the relevant links are stored in a td with the class "HeaderCell"
            Elements links = doc.select("td.HeaderCell a");
            for (Element link : links) {                    
                // These are all links to a silly java-script method, _doPostBack(..)
                // function __doPostBack(eventTarget, eventArgument) {
                //   if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
                //      theForm.__EVENTTARGET.value = eventTarget;
                //      theForm.__EVENTARGUMENT.value = eventArgument;
                //      theForm.submit();
                //   }
                // }
                // The important bits appear to be eventTarget and eventArgument at least,
                // but none of the links define an eventArgument in any case - so we just
                // need "eventTarget".

                // Naïve splitting, take the first quoted string
                Matcher m = p.matcher(link.attr("href"));
                if (m.find()) {
                    String eventTarget = m.group(1);
                    // The eventTarget you're looking for ends with 'ChangesTable'
                    if (eventTarget != null && eventTarget.endsWith("ChangesTable")) {
                        // Now we need to do a POST :-D - this API requires us to retain
                        // __VIEWSTATE - so we need to post that to.
                        doc = Jsoup.connect(src)
                                .data("__EVENTTARGET", eventTarget)
                                .data("__EVENTARGUMENT", "")
                                .data("__VIEWSTATE", 
                                        doc.select("input#__VIEWSTATE").attr("value"))
                                .data("__LASTFOCUS", "")
                                .post();


                        // All the lesson information is stored in a div with the class 
                        // TTLesson, so let's select those
                        Elements lessons = doc.select("div.TTLesson");
                        if (lessons.isEmpty()) {
                            Log.w(TAG, "Unable to list any lessons");
                        } else {
                            for (Element lesson : lessons) {
                                // This is were knowledge of Hebrew would come in handy -
                                // but this will list all lessons. You should be able
                                // to figure out how to find the one you want.
                                System.out.println(lesson);
                            }
                        }
                    }
                }
            }
        } else {
            Log.w(TAG, "Unable to find iframe src");
        }
    } else {
        Log.w(TAG, "Unable to find iframe");
    }
} catch (IOException e) {
    Log.w(TAG, "Error reading timetable", e);
}