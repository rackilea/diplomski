String newPath = path.createPolyLine(encodedPath);
String locationsContent="";
locationsContent = URLEncoder.encode(newPath, "UTF-8")
        .replaceAll("\\%40", "@")
        .replaceAll("\\+", "%20")
        .replaceAll("\\%21", "!")
        .replaceAll("\\%27", "'")
        .replaceAll("\\%28", "(")
        .replaceAll("\\%29", ")");