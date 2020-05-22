// Fetch the document
Document doc = Jsoup //
        .connect("https://sabq.org/%D8%B4%D8%A7%D9%87%D8%AF-%D8%A3%D9%84%D9%81-%D8%B5%D9%81%D8%AD%D8%A9-%D8%AA%D8%B1%D9%88%D9%8A-%D9%82%D8%B5%D8%B5-%D8%A7%D9%84%D8%AD%D8%B1%D9%85%D9%8A%D9%86-%D9%85%D9%86%D8%B0-%D8%A7%D9%86%D8%B7%D9%84%D8%A7%D9%82-%D8%A7%D9%84%D8%B9%D9%87%D8%AF-%D8%A7%D9%84%D8%B3%D8%B9%D9%88%D8%AF%D9%8A") //
        .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21") //
        .get();

// Look for the script containing the JSON data
Elements scripts = doc.select("script[data-cfasync=false]");
String content = null;
for (Element script : scripts) {
    String scriptText = script.html();
    if (scriptText.contains("dataFirstLoad")) {
        String dataFirstLoad = scriptText.replaceAll("(?i)^[\\s\\S]*dataFirstLoad\\s*=\\s*(\\{.+\\})\\s*;[\\s\\S]*$", "$1");

        JSONObject json = new JSONObject(dataFirstLoad);

        content = json.getJSONObject("material").getString("content");

        break;
    }
}

// Show content
System.out.println("Extracted content:\n" + content);