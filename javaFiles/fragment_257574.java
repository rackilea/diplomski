JSON query = o(
  "id", "/en/jimi_hendrix",
  "/common/topic/article", a(o(
    "text", o(
      "maxlength", 16384,
      "chars", null
    )
  ))
);
JSON envelope = o("extended", 1);
JSON params = o();
Freebase freebase = Freebase.getFreebase();
JSON response = freebase.mqlread(query, envelope, params);
String text = response.get("result")
                      .get("/common/topic/article")
                      .get(0).get("text")
                      .get("chars")
                      .toString();