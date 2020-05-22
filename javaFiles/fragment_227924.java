protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactListView = (ListView) findViewById(R.id.contactsListView);

        yourViewModel = ViewModelProviders.of(this).get(YourViewModel.class);

        if(contacts==null) contacts = new ArrayList<>();

        adapter = new ArrayAdapter<Contact>(this,android.R.layout.simple_list_item_1, contacts);
        contactListView.setAdapter(adapter);
        contactListView.setOnItemClickListener(this);

        yourViewModel.getContactList().observe(this, contactObserver);
}


Observer<List<Contact>> contactObserver = new Observer<List<Contact>>() {
        @Override
        public void onChanged(@Nullable List<Contact> newContacts) {
            if(adapter != null && newContacts != null) {
                adapter.clear();
                adapter.addAll(newContacts);
            }
        }
};