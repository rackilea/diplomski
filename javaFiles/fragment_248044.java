Object object = parser.parse ( message );
JSONArray array = (JSONArray) object;
for(int i=0;i < array.size () ; i++)
{
JSONArray jsonArray = ( JSONArray ) array.get ( i );
JSONObject jsonObj = (JSONObject) jsonArray.get(0);
String foodName = jsonObj.getString ( KEY_NAME );
Float calories = jsonObj.getFloat ( KEY_CARLORIES );
Nutrinfo info = new Nutrinfo(foodName,calories);
data.add ( info );
}