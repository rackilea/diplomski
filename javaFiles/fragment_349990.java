Map<String, String> langSel = new HashMap<String, String>();
langSel.add("en", true);
langSel.add("de", false);
langSel.add("fr", false);

JSONObject jsonObj = new JSONObject(langSel);
engine.put("langSel", jsonObj.toString());