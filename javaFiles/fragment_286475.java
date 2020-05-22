String URL = "http://abcd.com/region/country/state/123xyzCONSTANTTEXT.html";`

Pattern pattern = Pattern.compile("http://abcd.com/(\\w+/\\w+)");
Matcher matcher = pattern.matcher(URL);
if (matcher.find()) {
    System.out.println(matcher.group(1)); //prints region/country
} else {
    System.out.println("Match not found");
}