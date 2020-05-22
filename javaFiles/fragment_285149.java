public class ParticipantsSelectedActivity extends AppCompatActivity implements View.OnClickListener {

    DataBaseHandler myDb;
    ListView listViewParticipants;
    ParticipantsSelectedListAdapter participantsSelectedListAdapter;
    Participants participants;
    Button btn_save_participants_selected;
    CheckBox ckb;
    final ArrayList<Participants> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants_selected);

        myDb = new DataBaseHandler(this);
        ckb = (CheckBox) findViewById(R.id.ckb);

        listViewParticipants = (ListView) findViewById(R.id.listViewParticipantsSelected);
        btn_save_participants_selected = (Button) findViewById(R.id.btn_save_participants_selected);


        final Cursor cursor = myDb.getListParticipants();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "There is no participants", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                int id = (Integer.valueOf(cursor.getString(0)));
                String firstName = cursor.getString(1);
                String position = cursor.getString(3);

                participants = new Participants(id, firstName, position, true);
                listData.add(participants);
            }

            //Setting adapter after all data retrieve from database
            participantsSelectedListAdapter = new ParticipantsSelectedListAdapter(this, android.R.layout.simple_list_item_multiple_choice, listData);
            listViewParticipants.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            listViewParticipants.setAdapter(participantsSelectedListAdapter);
            btn_save_participants_selected.setOnClickListener(this);

        }
        /*

    listViewParticipants.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Participants participants = listData.get(position);

            Toast.makeText(getApplicationContext(), "Clicked on Id..." + participants.getId(), Toast.LENGTH_SHORT).show();
        }
    });

    */

    }

    @Override
    public void onClick(View v) {
        //another activity to fill another listView
        if (v.getId() == R.id.btn_save_participants_selected) {
            ArrayList<Participants> selectedListData = new ArrayList<>();
            if (listData != null && listData.size() > 0) {
                for (int i = 0; i < listData.size(); i++) {
                    if (listData.get(i).isSelected()) {
                        selectedListData.add(listData.get(i));
                    }
                }
                //Pass this selectedListData to new activity to show a new Listview
            }
        }

    }
}