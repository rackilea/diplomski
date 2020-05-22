public class PostActivity extends Activity {

    private static final String ENDPOINT = "https://kylewbanks.com/rest/posts.json";

    private RequestQueue requestQueue;
    private Gson gson;
    private List<String> posts_strs ;

    // keep it here for later use in other methods
    private List<Post> posts ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // code

        // initialize list
        posts_strs = new ArrayList<String>();

        // code
    }


    private final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            //Log.i(PostActivity.class.getSimpleName(), response);

            posts = Arrays.asList(gson.fromJson(response, Post[].class));
            //Log.i(PostActivity.class.getSimpleName(), posts.size() + " posts loaded.");

            List listview = (List) findViewById(R.id.postListView);

            for (Post post : posts) {
                 // add items to list
                 posts_strs.add( post.ID + ": " + post.title);
                //Log.i(PostActivity.class.getSimpleName(), post.ID + ": " + post.title);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(PostActivity.this,R.layout.single_post_item
                     ,R.id.textView, posts_strs);
            //   use the textview id posts_strs while creating adapter
            listview.setAdapter(adapter);

        }
    };
        // code

}