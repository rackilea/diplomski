Connection con = Jsoup
                .connect(
                        "http://static.adzerk.net/Advertisers/d18eea9d28f3490b8dcbfa9e38f8336e.jpg")
                .userAgent(
                        "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                .timeout(10000);

        Connection.Response resp = con.ignoreContentType(true).execute();
        byte[] image = resp.bodyAsBytes();
        FileOutputStream out = new FileOutputStream(new File(
                "C:/XXX/stackO.jpg"));

        out.write(image);
        out.close();