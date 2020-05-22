JSONObject first = array.getJSONObject(i);
    JSONArray getitems = first.getJSONArray("items");
    for (int j = 0; j < getitems.length(); j++) {

         JSONParser parser = new JSONParser();
         parser.setMenuname(first.getString("menu_name"));

         JSONObject sitems = getitems.getJSONObject(j);
         parser.setIid(sitems.getInt("id"));
         parser.setBaseName(sitems.getString("BaseName"));
         parser.setItemdesc(sitems.getString("itemdesc"));
         JSONArray subitems = sitems.getJSONArray("subitems");

         for (int l = 0; l < subitems.length(); l++) {

              JSONObject thrid = subitems.getJSONObject(l);
              parser.setSid(thrid.getInt("id"));
              parser.setSubItemdesc(thrid.getString("SubItemdesc"));
              parser.setSubItemprice(thrid.getString("SubItemprice"));

         }

         itemsdata.add(parser);
    }