URLConnection connection = new URL("http://www.stackoverflow.com").openConnection();
        InputStream inStream = connection.getInputStream();
        String htmlText = org.apache.commons.io.IOUtils.toString(inStream, connection.getContentEncoding());

        Document document = Jsoup.parse(htmlText);
        Elements els = document.select("tbody > tr > td");

        for (Element el : els) {
            System.out.println(el.text());
        }