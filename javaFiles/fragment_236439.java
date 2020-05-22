Document doc = Jsoup.parse(url);
       JSONObject jsonObject = new JSONObject();
       JSONArray list = new JSONArray();
       Element rows = doc.getElementsByTag("table tr");

      for(Element row : rows) {
          String Test = row.getElementsByTag("td").get(1).text();
          String Result = row.getElementsByTag("td").get(2).text();
          String Credit = row.getElementsByTag("td").get(3).text();

          jsonObject.put("Test", Test); 
          jsonObject.put("Result", Result);
          jsonObject.put("Credit", Credit); 
      }