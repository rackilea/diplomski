final String html = "<p><b>This <i>is</i></b> <i>my sentence</i> of text.</p>";

Document docHtml = Jsoup.parse(html);
Document docXml = Jsoup.parse(html, "", Parser.xmlParser());

System.out.println("******* HTML *******\n" + docHtml);
System.out.println();
System.out.println("*******  XML *******\n" + docXml);