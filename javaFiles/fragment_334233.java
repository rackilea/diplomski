@Override
protected String doInBackground() throws Exception {
    useragentwa = new read();
    userAgent = useragentwa.close();
    Document page = null;

    boolean shouldContinue = !isCancelled() || test;
    while (shouldContinue) {

        if (isCancelled()) {
            shouldContinue = false;
            continue;
        }

        finalDomain = http + "" + start_index + "" + domain;
        check = start_index % 20;
        if (check == 0) {
            useragentwa = new read();
            userAgent = useragentwa.close();
            System.out.println(userAgent);
        }
        if (isCancelled()) {
            shouldContinue = false;
            continue;
        }
        start_index++;
        System.out.println(start_index);
        try {
            page = Jsoup.connect(finalDomain).userAgent(userAgent).timeout(10 * 1000).get();
        } catch (Exception e) {
            start_index--;
            continue;
        }
        if (isCancelled()) {
            shouldContinue = false;
            continue;
        }
        if (page.title().contains("U.S. Directory - Online Yellow Pages")) {

            // area may want to append in console text area
            continue;

        } else {
            System.out.println("found something : " + finalDomain);
            test = false;
            shouldContinue = false;
            continue;
        }

    }

    return finalDomain;
}