public class ReminderList extends AppCompatActivity {

    public static ArrayList<ReminderType> AllReminders=new ArrayList<>();
    public reminderCAdapter adapter;
    public static ReminderType currentReminderType;
    public static ItemType currentItemType;
    public static TimeType currentTimesType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context=this;
        setContentView(R.layout.activity_reminder_list);
        //generate list
            try {
                LoadData();
            } catch (IOException | ClassNotFoundException | JSONException e) {
                e.printStackTrace();
            }
        alarmMan=(AlarmManager) getSystemService(ALARM_SERVICE);

        adapter=new reminderCAdapter(AllReminders,this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.listView);
        lView.setAdapter(adapter);
    }


    public void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public static void SaveData(Context context) throws IOException, JSONException {
        Log.e("Saving Data", "trying");

        JSONArray reminderData=new JSONArray();
        JSONObject reminder;
        JSONArray jItemData;
        JSONObject jItem;
        JSONArray jTimeData;
        JSONObject jTime;

        for(int i=0; i<AllReminders.size();i++){
            //create the reminder item
            reminder=new JSONObject();
            jItemData=new JSONArray();
            reminder.put("RemName",AllReminders.get(i).ReminderName);
            //create each of the itemtype items
            for(int j=0; j<AllReminders.get(i).Items.size();j++){
                jItem=new JSONObject();
                jTimeData=new JSONArray();
                jItem.put("iName",AllReminders.get(i).Items.get(j).ItemName);
                jItem.put("iNote",AllReminders.get(i).Items.get(j).AdditionalNote);
                //create each time item
                for(int h=0; h<AllReminders.get(i).Items.get(j).Times.size();h++){
                    jTime=new JSONObject();
                    jTime.put("hr",AllReminders.get(i).Items.get(j).Times.get(h).hour);
                    jTime.put("min",AllReminders.get(i).Items.get(j).Times.get(h).minute);
                    jTimeData.put(jTime);
                }
                //String tList=jTimeData.toString();
                jItem.put("timeList",jTimeData);
                jItemData.put(jItem);
            }
            //String iList=jItemData.toString();
            reminder.put("itemList",jItemData);
            Log.e("reminderItem", reminder.toString());
            reminderData.put(reminder);
        }
        String remList=reminderData.toString();
        FileOutputStream fos=context.openFileOutput("savedData",MODE_PRIVATE);
        fos.write(remList.getBytes());
        fos.close();
    }

    public void LoadData() throws IOException, ClassNotFoundException, JSONException {
        Log.e("Loading Data", "trying");
        FileInputStream fis=openFileInput("savedData");
        BufferedInputStream bis= new BufferedInputStream(fis);
        StringBuffer b=new StringBuffer();
        while(bis.available() !=0){
            char c=(char) bis.read();
            b.append(c);
        }

        bis.close();
        fis.close();

        JSONArray reminderData= new JSONArray(b.toString());
        //Log.e("b string", b.toString());

        for(int i=0; i<reminderData.length();i++){
            JSONObject remObj=reminderData.getJSONObject(i);
            String rName=remObj.getString("RemName");
            //Log.e("Rname",rName);
            ReminderType remi=new ReminderType(rName);
            JSONArray itemArray=remObj.getJSONArray("itemList");
            for(int h=0; h<itemArray.length();h++){
                JSONObject itemObj= itemArray.getJSONObject(h);
                String iName=itemArray.getJSONObject(h).getString("iName");
                //Log.e("iName",iName);
                ItemType iTem= new ItemType(iName);
                JSONArray timeArray=itemObj.getJSONArray("timeList");
                for(int j=0; j<timeArray.length();j++){
                    JSONObject timeObj=timeArray.getJSONObject(j);
                    int hr=timeObj.getInt("hr");
                    int min=timeObj.getInt("min");
                    TimeType tIme=new TimeType(hr,min);
                    tIme.SetDisplayTime();
                    iTem.Times.add(tIme);
                }
                remi.Items.add(iTem);
            }
            AllReminders.add(remi);
        }
    }

    public void AddToList(View view) throws IOException, JSONException {
        Intent intent = new Intent(this,ReminderSettings.class);
        intent.putExtra("Type", "new");
        startActivity(intent);
    }
}