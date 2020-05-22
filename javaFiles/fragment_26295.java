public JSONObject getValues()
{
    JSONObject jsonobj=new JSONObject();
    jsonobj.put("name","Ersin");
    jsonobj.put("surname","Çetinkaya");
    jsonobj.put("age","25");


    JSONArray obj = new JSONArray();
    HashMap rows=new HashMap();
    rows.put("city","Bursa");
    rows.put("country","Türkiye");
    rows.put("zipCode","33444");
    obj.put(rows);
    jsonobj.put("address", obj);

    JSONArray phobj = new JSONArray();
    phobj.put("234234242");
    phobj.put("345345354");
    jsonobj.put("phones", phobj);

    System.out.println(jsonobj.toString());
    return jsonobj.toString();
}