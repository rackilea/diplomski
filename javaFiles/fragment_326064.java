try {
     for (Element table : doc.select("table")) {
         for (Element row : table.select("tr")) {
             JSONObject jsonObject = new JSONObject();
             Elements tds = row.select("td");
             if(tds.size()==1){continue;} else{
                 String PhoneNo = tds.get(0).text();
                 String Officers = tds.get(1).text();
                 jsonObject.put("Phone No", PhoneNo);
                 jsonObject.put("Officers", Officers);
             }
             list.put(jsonObject);
         }
     }
} catch ( JSONException e) {
     e.printStackTrace();
}