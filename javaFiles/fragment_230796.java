root.getAsJsonObject()
    .get("collection").getAsJsonObject()
    .get("items").getAsJsonArray()
    .forEach(item -> item.getAsJsonObject()
       .get("links").getAsJsonArray()
       .forEach(link -> {
            JsonObject linkObject = link.getAsJsonObject();
            String relString = linkObject.get("rel").getAsString();
            if ("preview".equals(relString)) {
               hrefs.add(linkObject.get("href").getAsString());
            }));