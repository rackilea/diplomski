JSONObject jsonObject = new JSONObject("myjson string");
      JSONArray city=jsonObject.getJSONArray("cit");
      for(int i=0;i<city.length();i++)
      {
            String cities = (String) city.get(i);
            Log.i("All Cities",cities);
            kota.add(cities);
      }