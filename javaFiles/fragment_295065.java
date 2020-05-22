public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://9gag.com/gag/a2ZG6Yd").ignoreContentType(true)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .referrer("https://www.facebook.com/").timeout(12000).followRedirects(true).get();

        String html = doc.toString();

        Pattern p = Pattern.compile("\"vp9Url\":\"([^\"]+?)\"");
        Matcher m = p.matcher(html);
        if (m.find()) {
            String escpaedURL = m.group(1);
            String correctUrl = escpaedURL.replaceAll("\\\\", "");
            System.out.println(correctUrl);
            downloadFile(correctUrl);
        }
    }

    private static void downloadFile(String url) throws IOException {
        FileOutputStream out = (new FileOutputStream(new File("C:\\file.webm")));
        out.write(Jsoup.connect(url).ignoreContentType(true).execute().bodyAsBytes());
        out.close();
    }