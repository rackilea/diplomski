String jsonString="{
    "messageName": "ReportCard",
    "orgId": "Org1",
    "comment": true,
    "Fields": [{
       "objectId": "1234-56789-asdv",
       "fieldId": "1245-7852-dhjd"
    },
    {
       "objectId": "1234-56hgjgh789-hjjhj",
       "fieldId": "12sdf45-78sfg52-dfjhjd"
    }]
}"
JSONObject jObject= new JSONObject(jsonString);
JSONObject jo = new JSONObject(); //creating new Jobject
// putting data to JSONObject 
jo.put("messageName", jObject.getString("messageName").toString()); 
jo.put("orgId", jObject.getString("orgId").toString()); 
jo.put("comment", jObject.getString("comment").toString()); 

JSONArray Fields= jObject.getJSONArray("Fields");//extract field array
JSONArray ja = new JSONArray(); //creating new json array.
int Arraylength = Fields.length();
for(int i=0;i<Arraylength;i++)
{
    Map m = new LinkedHashMap(2); 
    JSONObject ArrayjObj = Fields.getJSONObject(i);
    m.put("objectId", ArrayjObj.getString("objectId").toString()); 
    m.put("fieldId", ArrayjObj.getString("fieldId").toString()); 
    // adding map to list 
    ja.add(m); 
 }
JSONObject fieldsObj = new JSONObject(); 
fieldsObj.put("Fields", ja); // Fields Array Created