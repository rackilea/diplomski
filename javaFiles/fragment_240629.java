Elements scriptTags = doc.getElementsByTag("script");
String re = "root\\.App\\.main\\s*\\=\\s*(.*?);\\s*\\}\\(this\\)\\)\\s*;";
String data = null;

for (Element script : scriptTags) {
    Pattern pattern = Pattern.compile(re, Pattern.DOTALL);
    Matcher matcher = pattern.matcher(script.html());

    if (matcher.find()) {
        data = matcher.group(1);
        break;
    }
}