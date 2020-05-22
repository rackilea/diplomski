String page = "<script type='text/javascript'><!--// <![CDATA[\n" +
        "    OA_show('300x250');\n" +
        "// ]]> --></script>\n" +
        "         <script type='text/javascript'>alert(\"Hello\");</script>";

String html = Jsoup.parse(page).select("script").get(0).html();
html = html.replace("<!--// <![CDATA[", "");
html = html.replace("// ]]> -->", "");

System.out.println(html);