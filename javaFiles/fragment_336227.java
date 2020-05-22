public User getUserByName(String firstName, String lastName) {
    synchronized (userList) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            if (user.getFirstName().equals(firstName)
                    && user.getLastName().equals(lastName)) {
                return user;
            }
        }
        // no user found
        return null;
    }
}


public class MainActivity extends FragmentActivity {
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private UserListAdapter<User> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
        final ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<User> usersList = new ArrayList<User>();
        // add items to list
        adapter = new UserListAdapter<User>(this,
                R.layout.textview_layout, usersList);
        listView.setAdapter(adapter);
        firstNameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    adapter.setFilterMode(UserListAdapter.MODE_FILTER_BY_FIRST_NAME);
                }
            }
        });
        lastNameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    adapter.setFilterMode(UserListAdapter.MODE_FILTER_BY_LAST_NAME);
                }
            }
        });
        TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s.toString());
            }
        };

        firstNameEditText.addTextChangedListener(textWatcher);
        lastNameEditText.addTextChangedListener(textWatcher);
    }

    public static class UserListAdapter<T> extends ArrayAdapter<T> {
        public static final int MODE_FILTER_BY_FIRST_NAME = 0xFEED;
        public static final int MODE_FILTER_BY_LAST_NAME = 0xDEAF;
        private List<T> objects;
        private int filterMode;

        public UserListAdapter(Context context, int textViewResourceId,
                List<T> objects) {
            super(context, textViewResourceId, objects);
            init(objects);
        }

        public UserListAdapter(Context context, int resource,
                int textViewResourceId, T[] objects) {
            super(context, resource, textViewResourceId, objects);
            init(Arrays.asList(objects));
        }

        private void init(List<T> objects) {
            this.objects = objects;
        }

        public UserListAdapter(Context context, int resource,
                int textViewResourceId, List<T> objects) {
            super(context, resource, textViewResourceId, objects);
            init(objects);
        }

        public UserListAdapter(Context context, int resource,
                int textViewResourceId) {
            super(context, resource, textViewResourceId);
        }

        public UserListAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public Filter getFilter() {
            return new Filter() {

                @Override
                protected void publishResults(CharSequence constraint,
                        FilterResults results) {
                    UserListAdapter.this.clear();
                    ArrayList<T> list = (ArrayList<T>) results.values;
                    UserListAdapter.this.addAll(list);
                    if (results.count > 0) {
                        notifyDataSetChanged();
                    } else {
                        notifyDataSetInvalidated();
                    }
                }

                @Override
                protected synchronized FilterResults performFiltering(
                        CharSequence constraint) {
                    FilterResults results = new FilterResults();
                    ArrayList<T> list = new ArrayList<T>();
                    Iterator<T> iterator = objects.iterator();
                    while (iterator.hasNext()) {
                        T t = (T) iterator.next();
                        User user = (User) t;
                        String s = null;
                        if (filterMode == MODE_FILTER_BY_FIRST_NAME) {
                            s = user.getFirstName();
                        } else if (filterMode == MODE_FILTER_BY_LAST_NAME) {
                            s = user.getLastName();
                        }
                        if (s.equals(constraint.toString())) {
                            list.add(t);
                        }
                    }
                    results.values = list;
                    results.count = list.size();
                    return results;
                }
            };
        }

        public int getFilterMode() {
            return filterMode;
        }

        public void setFilterMode(int filterMode) {
            this.filterMode = filterMode;
        }
    }

    public static class User {
        // attributes
        private String accountID;
        private String companyName;
        private String designation;
        private String firstName;
        private String lastName;
        private String profileimageBLOB;

        // behaviors
        public User() // default constructor
        {
            // attributes will be initialized to their default values
        }

        public User(String accID, String comName, String design, String fName,
                String lName, String image) // parameterized constructor
        {
            accountID = accID;
            companyName = comName;
            designation = design;
            firstName = fName;
            lastName = lName;
            profileimageBLOB = image;
        }

        // set and get methods
        public void setAccountID(String accID) {
            accountID = accID;
        }

        public String getAccountID() {
            return accountID;
        }

        public void setCompanyName(String comName) {
            companyName = comName;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setDesignation(String design) {
            designation = design;
        }

        public String getDesignation() {
            return designation;
        }

        public void setFirstName(String fName) {
            firstName = fName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setLastName(String lName) {
            lastName = lName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setProfileImage(String image) {
            profileimageBLOB = image;
        }

        public String getProfileImage() {
            return firstName;
        }

        // toString() method
        public String toString() {
            return accountID + "\t" + companyName + "\t" + designation + "\t\t"
                    + firstName + "\t" + lastName + "\t" + profileimageBLOB;
        }
    }
}