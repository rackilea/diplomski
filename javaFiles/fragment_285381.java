@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if(savedInstanceState == null) {
    MovieGridFragment fragment = new MovieGridFragment();
    fragment.setListener(this);   // some change here
                getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_container, fragment)
                .commit();
        movieData.movieDataPosition = 0;
    }
    if(savedInstanceState != null) {
        sorterString = savedInstanceState.getString("SORTER");
    }

    if(savedInstanceState == null)
        movieData.movieDataPosition = 0;

    if(sorterString==null)
        sorterString="popular?";
    if(sorterString!="favorite" && sorterString!=null) {
        if(networkChecker.isNetworkAvailableChecker(this)) {
            movieRequest();
        }
    }

}

.... no relevant functions 


public void movieRequest() {
        urlFinal = urlBase + sorterString + movieData.apiKey;
        urlFinal.trim();
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlFinal, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("results");
                    movieData.movieDataArray = new movieData[array.length()];

                    for (int i = 0; i < array.length(); i++) {
                        movieData movie = new movieData();
                        JSONObject jsonObject = array.getJSONObject(i);
                        //movie.setPosition(i);
                        movie.setMovieId(jsonObject.getString("id"));
                        movie.setMovieImagePath(jsonObject.getString("poster_path"));
                        movie.setMovieTitle(jsonObject.getString("original_title"));
                        movie.setMoviePlot(jsonObject.getString("overview"));
                        movie.setMovieVoting(jsonObject.getString("vote_average"));
                        movie.setMovieReleaseDate(jsonObject.getString("release_date"));
                        movieData.movieDataArray[i] = movie;
                    }

                    MovieGridFragment gridFragment = new MovieGridFragment();
                    gridfragment.setListener(this);  // some change here
                    gridFragment.movieDataList = Arrays.asList(movieData.movieDataArray); //hier wird datalist eigentlich zugewiesen
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.activity_container, gridFragment);
                    try {
                        transaction.commitAllowingStateLoss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("volley", String.valueOf(error));
            }
        }
        );
        requestQueue.add(jsonObjectRequest);

}