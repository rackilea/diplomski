List<String> linksWOSpace = new ArrayList<String>();

int numberOfLinks = selenium.getXpathCount("//li/div/h3/a");
for (int i = 1; i <= numberOfLinks; i++) {
    // gets the <a> elements one by one
    linksWOSpace.add(selenium.getText("xpath=(//li/div/h3/a)[" + i + "]"));
}