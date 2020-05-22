@Override
            protected FilterResults performFiltering(CharSequence constraint) {

                ArrayList<String> resultList = null;
                FilterResults filterResults = new FilterResults();

                if (constraint != null) {
                    // Retrieve the autocomplete results.
                    Log.d(TAG, "Starting Search");

                    HttpURLConnection conn = null;
                    StringBuilder jsonResults = new StringBuilder();
                    try {
                        KEYWORD = constraint.toString();

                        ENDPOINT = Uri
                                .parse("https://maps.googleapis.com/maps/api/place/nearbysearch/json")
                                .buildUpon()
                                .appendQueryParameter("location", LOCATION)
                                .appendQueryParameter("radius", "10000")
                                .appendQueryParameter("keyword", KEYWORD)
                                .appendQueryParameter("key", API_KEY)
                                .build();

                        URL url = new URL(ENDPOINT.toString());

                        Log.d(TAG, "URL: " + url);

                        conn = (HttpURLConnection) url.openConnection();
                        InputStreamReader in = new InputStreamReader(conn.getInputStream());

                        // Load the results into a StringBuilder
                        int read;
                        char[] buff = new char[1024];
                        while ((read = in.read(buff)) != -1) {
                            jsonResults.append(buff, 0, read);
                        }
                        Log.d(TAG, jsonResults.toString());
                    } catch (MalformedURLException e) {
                        Log.e(TAG, "Error processing Places API URL", e);
                        return filterResults ;
                    } catch (IOException e) {
                        Log.e(TAG, "Error connecting to Places API", e);
                        return filterResults ;
                    } finally {
                        if (conn != null) {
                            conn.disconnect();
                        }
                    }
                    try {
                        // Create a JSON object hierarchy from the results
                        JSONObject jsonObj = new JSONObject(jsonResults.toString());
                        JSONArray predsJsonArray = jsonObj.getJSONArray("results");

                        // Extract the Place descriptions from the results
                        resultList = new ArrayList(predsJsonArray.length());
                        for (int i = 0; i < predsJsonArray.length(); i++) {
                            System.out.println(predsJsonArray.getJSONObject(i).getString("name"));
                            System.out.println(predsJsonArray.getJSONObject(i).getString("vicinity"));
                            System.out.println("=====================================================");
                            resultList.add(predsJsonArray.getJSONObject(i).getString("name"));
                            resultList.add(predsJsonArray.getJSONObject(i).getString("vicinity"));
                        }
                    } catch (JSONException e) {
                        Log.e(TAG, "Cannot process JSON results", e);
                    }
                    Log.d(TAG, resultList.toString());

                    // Assign the data to the FilterResults
                    filterResults.values = resultList;
                    filterResults.count = resultList.size();
                }
                return filterResults;
            }