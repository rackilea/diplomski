public class StoriesFragment extends Fragment {

    private int authorID;
    private String authorName;

    public StoriesFragment() {
        // Required empty public constructor
    }

    public static StoriesFragment newInstance(int authorID, String authorName) {

        Bundle args = new Bundle();
        args.putInt("author_id", authorID);
        args.putString("author_name", authorName);

        StoriesFragment fragment = new StoriesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private ListView storiesListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Here is your arguments
        authorID = getArguments().getInt("author_id");
        authorName = getArguments().getString("author_name");

        // link ListView object with XML ListView
        storiesListView = (ListView) findViewById(R.id.stories_list_view);

        // create new instance of DatabaseHelper
        DatabaseHelper db = new DatabaseHelper(this);

        // create list of stories through getAllStories method
        List<Book> storyList = db.getAllStories(authorID);

        // create new ArrayAdapter
        ArrayAdapter<Book> arrayAdapter =
                new ArrayAdapter<Book>(this, android.R.layout.simple_list_item_1, storyList);

        // link ListView and ArrayAdapter
        storiesListView.setAdapter(arrayAdapter);

        Log.i("test", storyList.toString());

        storiesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Book story = (Book) storiesListView.getItemAtPosition(i);
                //Log.i("click", story);

                Intent intent = new Intent(StoriesActivity.this, StoryBodyActivity.class);
                intent.putExtra("story", story.getTitle());
                startActivity(intent);

                //Log.i("click", "That's a click!");
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stories, container, false);
    }

}