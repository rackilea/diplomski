URL url = new URL("https://www.imdb.com/chart/top/");
InputStream is = url.openStream();

StringBuilder sb = new StringBuilder();
try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
    String line;
    while ((line = br.readLine()) != null) {
        sb.append(line);
    }
} catch (MalformedURLException e) {
    e.printStackTrace();
    throw new MalformedURLException("URL is malformed!!");
} catch (IOException e) {
    e.printStackTrace();
    throw new IOException();
}

// Full line
Pattern pattern = Pattern.compile("<td class=\"titleColumn\">.*?</td>");
String content = sb.toString();
Matcher matcher = pattern.matcher(content);
while (matcher.find()) {
    System.out.println(matcher.group());
}

// Title only
Pattern pattern = Pattern.compile("<td class=\"titleColumn\">.+?<a href=.+?>(.+?)</a>.+?</td>");
String content = sb.toString();
Matcher matcher = pattern.matcher(content);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}