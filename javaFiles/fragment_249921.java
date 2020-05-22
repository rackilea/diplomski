class YourTask extends AsyncTask<JSONArray, String, ArrayList<Blogs> > {
    ArrayList<Blogs> auxArrayList;
    @Override
    protected ArrayList<Blogs> doInBackground(JSONArray... result) {
        auxArrayList=parseJSONResponse(result[0]);
        return auxArrayList;
    }

    @Override
    protected void onPostExecute(ArrayList<Blogs> blogs) {
        mAdapterDashBoard.setBloglist(listblogs);
    }
}



private void JsonRequestMethod() {
    final long start = SystemClock.elapsedRealtime();
            mVolleySingleton = VolleySingleton.getInstance();
            //intitalize Volley Singleton request key
            mRequestQueue = mVolleySingleton.getRequestQueue();
            //2 types of requests an Array request and an Object Request
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL_API, (String) null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    System.out.print(response);
                    try {
                        listblogs.clear();
                        listblogs = new YourTask().execute(response).get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                    System.out.println(response);
                            Log.d("Testing", "Time elapsed: " + (SystemClock.elapsedRealtime() - start));
                    System.out.println("it worked!!!");
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
            mRequestQueue.add(request);
    }



private ArrayList<Blogs> parseJSONResponse(JSONArray response) {
    ArrayList<Blogs> myAuxArrayList = null;
    if (!response.equals("")) {

        try {
             myAuxArrayList = new ArrayList<Blogs>();
            StringBuilder data = new StringBuilder();
            for (int i = 0; i < response.length(); i++) {
                JSONObject currentQuestions = response.getJSONObject(i);
                String text = currentQuestions.getString("text");
                String points = currentQuestions.getString("points");
                String ID=currentQuestions.getString("id");
                String studentId = currentQuestions.getString("studentId");
                String DateCreated=currentQuestions.getString("created");
                long time=Long.parseLong(DateCreated.trim());
                data.append(text + "\n" + points + "\n");
                System.out.println(data);
                Blogs blogs = new Blogs();
                blogs.setId(ID);
                blogs.setMstudentId(studentId);
                blogs.setMtext(text);
                blogs.setPoints(points);
                //The dateCreated was off by 1 hour so 3600000 ms where added=1hour, (UPDATE)
                blogs.setDateCreated(getTimeAgo(time));
                System.out.println(time + "time");


                myAuxArrayList.add(blogs);


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    return myAuxArrayList;
}