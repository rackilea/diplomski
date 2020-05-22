String url ="http://m.people.com/img/ic?width=474&height=269&fsize=999000&format=jpg&url=http%3A%2F%2Fimg2.timeinc.net%2Fpeople%2Fi%2F2011%2Fnews%2F110425%2Fgwyneth-paltrow-300.jpg";
Map<String, List<String>> params = new HashMap<String, List<String>>();
String[] urlParts = url.split("\\?");
if (urlParts.length > 1) {
    String query = urlParts[1];
    for (String param : query.split("&")) {
        String[] pair = param.split("=");
        String key;
        try
        {
          key = URLDecoder.decode(pair[0], "UTF-8");
        } catch (UnsupportedEncodingException e)
        {
          key = URLDecoder.decode(pair[0]);
        }
        String value;
        try
        {
          value = URLDecoder.decode(pair[1], "UTF-8");
        } catch (UnsupportedEncodingException e)
        {
          value = URLDecoder.decode(pair[1]);
        }
        List<String> values = params.get(key);
        if (values == null) {
            values = new ArrayList<String>();
            params.put(key, values);
        }
        values.add(value);
    }
}
String img = params.get("url").get(0);
String[] parts = img.split("/");
String imgName = parts[parts.length - 1];
System.out.println(imgName);