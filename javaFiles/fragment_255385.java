List<String> featureTitleCleaned = new ArrayList<>();
Elements tes = doc.select("div.pd__content__row");
Elements spesifikasiProductContent = tes.select("[class=pd__spec__table]");

String cleaned = "";
for (Element element : spesifikasiProductContent) {
    for (Element rowElement : element.select("tr")) {
        cleaned += rowElement.text()+"\n";
    }
    featureTitleCleaned.add(cleaned);
    cleaned = "";
}

for (String listElement : featureTitleCleaned) {
    System.out.println(listElement);
}