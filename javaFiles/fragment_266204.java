JSONArray arr = new JSONArray();
         while (rstcust.next()) {
              JSONObject obj = new JSONObject();
              obj.put("label", rstcust.getString(3));
              obj.put("ID", rstcust.getInt(1));
              arr.put(obj);
              }
out.print(arr);