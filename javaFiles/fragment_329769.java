BufferedInputStream bufferPage = new BufferedInputStream(new URL("http://www.yourUrl.com").openStream());

Tidy tidy = new Tidy();
tidy.setQuiet(true);
tidy.setShowWarnings(false);
tidy.setInputEncoding("UTF-8");
Document document = tidy.parseDOM(bufferPage, null);
document.normalize();