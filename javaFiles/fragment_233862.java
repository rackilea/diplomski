public class Test extends Activity{
        DBAdapter DBAdapter;
        ListView FriendLV;
        Button playbutton;
        final TextView friend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playafriend);
        final DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor friendslist = db.GetAllFriends();
         if(friendslist.getCount()!=0){
             FriendLV = (ListView) findViewById(android.R.id.list);
             playbutton = (Button) findViewById(R.id.playbutton);
             friend = (TextView) findViewById(R.id.textview_friends);
             String[] from = new String[] {"FRIENDS"};   // your column/columns here
                int[] to = new int[] {R.id.textview_friends};

                @SuppressWarnings("deprecation")
                ListAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.list_items, friendslist, from, to,0);
                  FriendLV.setAdapter(cursorAdapter);
                  playbutton.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub

                            String Defender = friend.getText().toString();
                            db.GetFriend(Defender);
                            startActivity(new Intent ("com.fullfrontalgames.numberfighter.Fightattacker"));
                            db.close();
                        }
                    }); 
         }
    }

    }