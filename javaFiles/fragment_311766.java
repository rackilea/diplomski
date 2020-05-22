Document doc = Jsoup.parse("" +
    "<p>THIS &mdash; IS A &ldquo;TEST&rdquo;. 5 &gt; 4. trademark: &#153;</p>");

Document.OutputSettings settings = doc.outputSettings();

settings.prettyPrint(false);
settings.escapeMode(Entities.EscapeMode.extended);
settings.charset("ASCII");

String modifiedFileHtmlStr = doc.html();

System.out.println(modifiedFileHtmlStr);