Document doc = Jsoup.parse(line);
Elements pElems = doc.select("div.entry > p");

for (Element pElem : pElems) {
   myArrayList.add(pElem.data());
}