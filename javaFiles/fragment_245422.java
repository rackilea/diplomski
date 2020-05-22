public class MainListActivityFragment extends Fragment {
    protected String[] mBlogPostTitles;
    protected JSONObject mBlogData;
    public static final String LOG_TAG = MainListActivityFragment.class.getSimpleName();
    public static ArrayAdapter<String> titleAdapter;
    ListView listView;


public MainListActivityFragment() {
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main_list, container, false);

    listView = (ListView) rootView.findViewById(R.id.listview_name);


         if(isNetworkAvailable()) {
        GetBlogPost getBlogPost = new GetBlogPost();
        getBlogPost.execute();
    } else {
        Toast.makeText(getContext(),"No Network Available", Toast.LENGTH_LONG).show();
    }


    return rootView;

}

private void updateList() {
    if(mBlogData == null){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Oopps");
        builder.setMessage("There was an error accessing the blog ...");
        builder.setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();


    }else {
        try {
            JSONArray jsonPosts = mBlogData.getJSONArray("posts");

            mBlogPostTitles = new String[jsonPosts.length()];
            for (int i = 0; i < jsonPosts.length(); i++){
                JSONObject post = jsonPosts.getJSONObject(i);
                String title = post.getString("title");
                title = Html.fromHtml(title).toString();
                mBlogPostTitles[i] = title;


            }


        } catch (JSONException e) {
            Log.e(LOG_TAG,"Exception Caught: ",e);
        }
    }
}

public class GetBlogPost extends AsyncTask<Object, Void, JSONObject> {
    public final int NUMBER_OF_POSTS = 5;

    int responseCode = -1;
    JSONObject jsonResponse = null;

    @Override
    protected JSONObject doInBackground(Object... params) {

        try {
            URL blogFeedUrl = new URL("http://www.example.com/api/get_category_posts/?slug=americancuisines&count="+NUMBER_OF_POSTS);
            HttpURLConnection connection = (HttpURLConnection) blogFeedUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                String blogDataJsonStr = buffer.toString();

                jsonResponse = new JSONObject(blogDataJsonStr);

            }else {
                Log.i(LOG_TAG, "Unsuccessful HTTP Response Code: " + responseCode);
            }
        }
        catch (MalformedURLException e){
            Log.e(LOG_TAG,"Exception Caught: ",e);
        }
        catch (IOException e) {
            Log.e(LOG_TAG, "IO Exception Caught: ",e);
        }
        catch (Exception e) {
            Log.e(LOG_TAG,"Exception Caught: ",e);
        }
        return jsonResponse;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        super.onPostExecute(result);
        mBlogData = result;
        updateList();

        List<String> blogTitles = new ArrayList<>(Arrays.asList(mBlogPostTitles));
        titleAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.name_list_view,
                R.id.name_list_view_textview,
                blogTitles
        );
        listView.setAdapter(titleAdapter);

    }
}