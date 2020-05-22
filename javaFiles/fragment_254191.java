JSONArray jsonarray = new JSONArray(json);

for (int i = 0; i < jsonarray.length(); i++) {

       JSONObject jsonobj = jsonarray.getJSONObject(i);

      System.out.println("categoryId : " + i + " = " + jsonobj.getString("categoryId"));
       System.out.println("Title : " + i + " = " + jsonobj.getString("Title"));
       System.out.println("songs : " + i + " = " + jsonobj.getString("songs"));
}