String dna = "xxxATGxxxxxxxxxxxxxxTAGxxxxxxxxx";
Matcher m = Pattern.compile("ATG.*TAG").matcher(dna);
List<String> genes = new ArrayList<String>();
while (m.find()) {
    genes.add(m.group());
}