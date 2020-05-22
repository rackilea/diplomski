public class Fragment1 extends Fragment {

    public interface Constants {
        String LOG = "com.dooba.beta";
    }

    private String currentUserId;
    private ArrayAdapter<String> namesArrayAdapter;
    private ArrayList<String> names;
    private ArrayList<String> age;
    private ArrayList<String> headline;
    private ArrayList<String> activityname;

    private ArrayList<Images> alProfilePicture;
    private ListView usersListView;
    private Button logoutButton;
    String userGender = ParseUser.getCurrentUser().getString("Gender");
    String activityName = ParseUser.getCurrentUser().getString("ActivityName");
    Number maxDistance = ParseUser.getCurrentUser().getNumber(
            "Maximum_Distance");
    String userLookingGender = ParseUser.getCurrentUser().getString(
            "Looking_Gender");
    Number minimumAge = ParseUser.getCurrentUser().getNumber("Minimum_Age");
    Number maximumAge = ParseUser.getCurrentUser().getNumber("Maximum_Age");
    Number userage = ParseUser.getCurrentUser().getNumber("Age");

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setConversationsList();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container,
                false);

        return view;
    }

    private void setConversationsList() {
        currentUserId = ParseUser.getCurrentUser().getObjectId();
        names = new ArrayList<String>();
        age = new ArrayList<String>();
        headline = new ArrayList<String>();
        activityname = new ArrayList<String>();

        alProfilePicture = new ArrayList<Images>();

        // String userActivitySelectionName = null;

        ParseQuery<ParseUser> query = ParseUser.getQuery();

        // query.whereEqualTo("ActivityName",userActivitySelectionName);

        query.whereNotEqualTo("objectId", ParseUser.getCurrentUser()
                .getObjectId());
        // users with Gender = currentUser.Looking_Gender
        query.whereEqualTo("Gender", userLookingGender);
        // users with Looking_Gender = currentUser.Gender
        query.whereEqualTo("Looking_Gender", userGender);
        query.setLimit(1);
        query.whereEqualTo("ActivityName", activityName);
        // query.whereGreaterThanOrEqualTo("Age", minimumAge);
        // query.whereLessThanOrEqualTo("Age", maximumAge);
        query.orderByDescending("Name");

        Log.d(Constants.LOG, "");

        ParseQuery<ParseObject> queryo = ParseQuery.getQuery("User");

        queryo.whereNotEqualTo("objectId", ParseUser.getCurrentUser()
                .getObjectId());
        // users with Gender = currentUser.Looking_Gender
        queryo.whereEqualTo("Gender", userLookingGender);
        // users with Looking_Gender = currentUser.Gender
        queryo.whereEqualTo("Looking_Gender", userGender);
        queryo.setLimit(1);
        queryo.whereEqualTo("ActivityName", activityName);
        // query.whereGreaterThanOrEqualTo("Age", minimumAge);
        // query.whereLessThanOrEqualTo("Age", maximumAge);
        queryo.orderByDescending("Name");


        queryo.findInBackground(new FindCallback<ParseObject>() {


            @Override
            public void done(List<ParseObject> object, ParseException e) {
                // TODO Auto-generated method stub
                ParseFile image = object.getParseFile("ProfilePicture");

                ParseImageView imageView = (ParseImageView) getView()
                        .findViewById(R.id.profilePictureResult);

                // The placeholder will be used before and during the fetch, to
                // be replaced by the fetched image
                // data.
                imageView.setPlaceholder(getResources().getDrawable(
                        R.drawable.profile_pict));
                imageView.setParseFile(image);
                imageView.loadInBackground(new GetDataCallback() {
                    @Override
                    public void done(byte[] data, ParseException e) {
                        Log.i("ParseImageView",
                                "Fetched! Data length: " + data.length
                                        + ", or exception: " + e.getMessage());
                    }
                });
            }
        });

        query.findInBackground(new FindCallback<ParseUser>() {

            public void done(List<ParseUser> userlistname, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < userlistname.size(); i++) {
                        names.add(userlistname.get(i).get("Name").toString());
                    }
                    usersListView = (ListView) getActivity().findViewById(
                            R.id.userlistname);
                    namesArrayAdapter = new ArrayAdapter<String>(getActivity()
                            .getApplicationContext(), R.layout.user_list_item,
                            names);
                    usersListView.setAdapter(namesArrayAdapter);

                    usersListView
                            .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> a,
                                                        View v, int i, long l) {
                                    openConversation(names, i);
                                }
                            });

                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Error loading user list", Toast.LENGTH_LONG)
                            .show();
                }
            }

            public void done1(List<ParseUser> userlistheadline, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < userlistheadline.size(); i++) {
                        headline.add(userlistheadline.get(i).get("Headline")
                                .toString());
                    }
                    usersListView = (ListView) getActivity().findViewById(
                            R.id.userlistheadline);
                    namesArrayAdapter = new ArrayAdapter<String>(getActivity()
                            .getApplicationContext(), R.layout.user_list_all,
                            headline);
                    usersListView.setAdapter(namesArrayAdapter);

                    usersListView
                            .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> a,
                                                        View v, int i, long l) {
                                    openConversation(names, i);
                                }
                            });

                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Error loading user list", Toast.LENGTH_LONG)
                            .show();
                }
            }

            public void done2(List<ParseUser> userlistage, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < userlistage.size(); i++) {
                        age.add(userlistage.get(i).get("Age").toString());
                    }
                    usersListView = (ListView) getActivity().findViewById(
                            R.id.userlistage);
                    namesArrayAdapter = new ArrayAdapter<String>(getActivity()
                            .getApplicationContext(), R.layout.user_list_item,
                            age);
                    usersListView.setAdapter(namesArrayAdapter);

                    usersListView
                            .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> a,
                                                        View v, int i, long l) {
                                    openConversation(names, i);
                                }
                            });

                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Error loading user list", Toast.LENGTH_LONG)
                            .show();
                }
            }

            public void done3(List<ParseUser> userlistactivity, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < userlistactivity.size(); i++) {
                        activityname.add(userlistactivity.get(i)
                                .get("ActivityName").toString());
                    }
                    usersListView = (ListView) getActivity().findViewById(
                            R.id.userlistactivityname);
                    namesArrayAdapter = new ArrayAdapter<String>(getActivity()
                            .getApplicationContext(), R.layout.user_list_item,
                            activityname);
                    usersListView.setAdapter(namesArrayAdapter);

                    usersListView
                            .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> a,
                                                        View v, int i, long l) {
                                    openConversation(names, i);
                                }
                            });

                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Error loading user list", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

    }

    public void openConversation(ArrayList<String> names, int pos) {
        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.whereEqualTo("Name", names.get(pos));
        query.findInBackground(new FindCallback<ParseUser>() {
            public void done(List<ParseUser> user, ParseException e) {
                if (e == null) {
                    Intent intent = new Intent(getActivity()
                            .getApplicationContext(), MessagingActivity.class);
                    intent.putExtra("RECIPIENT_ID", user.get(0).getObjectId());
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Error finding that user", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

}