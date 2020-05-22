File picutreFile = new File("src/test.jpg");
         URL url=new URL("http://paceoil.ca/files/includes/images/images-stories-presentation-october-icon-graphic.jpg");
         URLConnection conn = url.openConnection();
         conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:31.0) Gecko/20100101 Firefox/31.0");
         conn.connect();
            FileUtils.copyInputStreamToFile(conn.getInputStream(), picutreFile);