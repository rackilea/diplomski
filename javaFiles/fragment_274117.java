@Override
  protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.displaylistview_layout);
       listView=(ListView) findViewById(R.id.listview);
       listView.setAdapter(dataAdapter);
       dataAdapter=new dataAdapter(this,R.layout.row_layout);
       json_string=getIntent().getExtras().getString("json_data");
       Log.w("var32",  json_string);
       try {
           jsonArray = new JSONArray(json_string);
           int count=0;
           String LabLocation,RackLocation,ShelfLocation,fourBid,Cluster,fourBookingName,SoftwareVersion,HardwareType,AssetNo,SerialNo;
           while (count <  jsonArray.length())
          {
               JSONObject JO=jsonArray.getJSONObject(count);
               jsonObject = JO.getJSONObject("_id");


               LabLocation=JO.getString("LabLocation");
               RackLocation=JO.getString("RackLocation");
               ShelfLocation=JO.getString("ShelfLocation");
               fourBid=JO.getString("fourBid");
               Cluster=JO.getString("Cluster");
               fourBookingName=JO.getString("fourBookingName");
               SoftwareVersion=JO.getString("SoftwareVersion");
               HardwareType=JO.getString("HardwareType");
               AssetNo=JO.getString("AssetNo");
               SerialNo=JO.getString("SerialNo");

              data data=new data(LabLocation,RackLocation,ShelfLocation,fourBid,Cluster,fourBookingName,SoftwareVersion,HardwareType,AssetNo,SerialNo);

              dataAdapter.add(data);

              count++;
           }

       }catch (JSONException e){
           Log.w("var33", "error JSON exception");
           e.printStackTrace();
       }
   }