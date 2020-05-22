String s = "<      pre href = \" dajflka \" >";
Pattern pattern = Pattern.compile("<(?<doubletag>[ ]*[a-z]+)([ \\d\\s\\w\\W[^>]])*>");
Matcher match = pattern.matcher(s);
if (match.find()) {
    System.out.println("Found");
    System.out.println(match.group("doubletag"));
}