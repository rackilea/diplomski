protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button b1 = (Button)findViewById(R.id.button);
    assert b1 != null;
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ContactsObject newUser2 = new ContactsObject("user1", "user1@gmail.com", "5145789076" );
            adapter.add(newUser2);
        }
    });

    arrayOfUsers = new ArrayList<ContactsObject>();
    ContactsObject user2 = new ContactsObject("user2", "user2@gmail.com", "5145789076" );
    arrayOfUsers.add(user2);
    adapter = new ContactAdapter(this, arrayOfUsers);
    ListView  listView = (ListView) findViewById(android.R.id.list);
    listView.setAdapter(adapter);
}