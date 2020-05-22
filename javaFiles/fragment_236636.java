private static void test() {
    Document doc = null;
    Elements dateDivs = null;
    Elements postContentDivs = null;
    Elements fbCustomShareDivs = null;
    Element specificIdDiv = null;

    try {
        doc = Jsoup.connect(url).get();

        /** First part of example, I assume all elements are unique in term of classname, which means for eg there is only one DIV element with date as classname **/
        /** Find all SPAN element with matched CLASS name **/
        dateDivs = doc.select("div.date");

        if (dateDivs.size() > 0) {
            String date = dateDivs.get(0).text();
            System.out.println("date: " + date);
        }
        else {
            System.out.println("No DIV element found with class date.");
        }

        /** Find all SPAN element with matched CLASS name **/
        postContentDivs = doc.select("div.postContent");

        if (postContentDivs.size() > 0) {
            String postContent = postContentDivs.get(0).text();
            System.out.println("postContent: " + postContent);
        }
        else {
            System.out.println("No DIV element found with postContentDivs date.");
        }

        /** Find all SPAN element with matched CLASS name **/
        fbCustomShareDivs = doc.select("div.fb-custom-share");

        if (fbCustomShareDivs.size() > 0) {
            String dataurl = fbCustomShareDivs.get(0).attr("data-url");
            System.out.println("dataurl: " + dataurl);
        }
        else {
            System.out.println("No DIV element found with fb-custom-share date.");
        }

        /** Second part of example **/
        /** If elements are not unique in term of class name, then use following code to retrieve DIV with ID first. **/
        /** Then only continue to retrieve elements inside DIV id post162 **/
        specificIdDiv = doc.getElementById("post162");

        if (specificIdDiv != null) {
            postContentDivs = specificIdDiv.select("div.postContent");

            if (postContentDivs.size() > 0) {
                String postContent = postContentDivs.get(0).text();
                System.out.println("postContent: " + postContent);
            }
            else {
                System.out.println("No DIV element found with postContentDivs date.");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}