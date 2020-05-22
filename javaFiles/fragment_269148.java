// Parse str into a Document
Document doc = Jsoup.parse(str);

// Clean the document.
doc = new Cleaner(Whitelist.simpleText()).clean(doc);

// Adjust escape mode
doc.outputSettings().escapeMode(EscapeMode.xhtml);

// Get back the string of the body.
str = doc.body().html();