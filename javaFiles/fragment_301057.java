boolean available=false;

JSONArray Jarray = new JSONArray(result);
for(int i=0;i<Jarray.length();i++)
{
    JSONObject Jasonobject = null;
    //text_1 = (TextView)findViewById(R.id.txt1);
    Jasonobject = Jarray.getJSONObject(i);

    //get an output on the screen
    //String id = Jasonobject.getString("id");
    String name = Jasonobject.getString("name");
    String db_detail="";
    if(et.getText().toString().equalsIgnoreCase(name)) 
    {
        db_detail = Jasonobject.getString("detail");
        text.setText(db_detail);
        available=true;
        break;
    } 
}

if(!available)
      Toast.makeText(MainActivity.this, "Not available", Toast.LENGTH_LONG).show();