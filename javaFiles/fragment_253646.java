public class MainActivity extends Activity 
    {
        ListView lv;
        ArrayAdapter<String> adapter;
        Button delete;
        ArrayList<String> data = new ArrayList<String>();
        SparseBooleanArray mCheckStates ;
        @Override
        protected void onCreate(Bundle savedInstanceState) 
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.test);
            lv = (ListView)findViewById(R.id.listView1);
            lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            delete = (Button)findViewById(R.id.button1);
            data.add("Windows");
            data.add("Android");
            data.add("Apple");
            data.add("Blackberry");
            adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_multiple_choice, data);
            lv.setAdapter(adapter);

            delete.setOnClickListener(new OnClickListener()
            {
            @Override
            public void onClick(View v)
            {

                 SparseBooleanArray checkedItemPositions = lv.getCheckedItemPositions();
                 int itemCount = lv.getCount();

                 for(int i=itemCount-1; i >= 0; i--){
                     if(checkedItemPositions.get(i)){
                         adapter.remove(data.get(i));
                     }
                 }
                 checkedItemPositions.clear();
                 adapter.notifyDataSetChanged();

            }
            });
        }
    }