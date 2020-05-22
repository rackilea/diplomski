Document doc = Jsoup.parse("<div>b a b <span>b c</span> d b</div> ");
System.out.println("BEFORE CHANGES:");
System.out.println(doc);

Element id1 = doc.select("div").first();
for (TextNode textNode : id1.textNodes()) {
    wrapTextWithElement(textNode, "b", "<span class='x'>");
}

System.out.println();
System.out.println("AFTER CHANGES");
System.out.println(doc);