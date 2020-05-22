String[] arrayOfLine = {"I.2 Other Interpretive Provisions" , "I.3 Accounting Terms","Including all","II.1 The Loans","II.3 Prepayments.","III.2 Illegality","IV.2 Conditions","V.2 Authorization","expected to have"};
Pattern pat = Pattern.compile("^[A-Z]+\\.[0-9]+\\b");
List<String> listOfHeadings = new ArrayList<>();
for (String s : arrayOfLine) {
    Matcher m = pat.matcher(s);
    if (m.find()) {
        listOfHeadings.add(s);
    }
}
System.out.println(listOfHeadings);