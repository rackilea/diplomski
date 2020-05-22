String jsonContent = "" +
            "<img alt=\"Image1\" src=\"/sites/default/files/Image1.jpg\"/>" + "\n" +
            "<img alt=\"Image1\" src=\"/sites/default/files/Image1.jpg\"/>" + "\n" +
            "<img alt=\"Image1\" src=\"/sites/default/files/Image1.jpg\"/>" + "\n" +
            "<img alt=\"Image1\" src=\"/sites/default/files/Image1.jpg\"/>";

    String htmlText = jsonContent.replaceAll("src=\"", "src=\"https://somesite.com");