String str = "<form ... id=\"gaia_loginform\" ... >\nCONTENT\n</form>";
Pattern pat = Pattern.compile("<form\\b[^>]*\\bid=[\"']gaia_loginform[\"'][^>]*>(.*?)</form>", Pattern.DOTALL);
Matcher matcher = pat.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}