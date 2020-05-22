String html = "<div>This<br>is<br />a<br>test</div>";
html = html.replaceAll("<br(?:\\s+/)?>", "_brSplitPos_");
Document docH = Jsoup.parse(html);
String onlyText = docH.text();
onlyText = onlyText.replace("_brSplitPos_", "<br />");
System.out.println(onlyText);