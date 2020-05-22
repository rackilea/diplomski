textView.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence s, int start, int before,
                int count) {
            GetPlaces task = new GetPlaces();
            String check = textView.getText().toString();
            if (check.trim().isEmpty()) {
                // do something here
                }
            } else {
                // now pass the argument in the textview to the task
                task.execute(check);
                listView.setVisibility(View.VISIBLE);
            }

        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
            // TODO Auto-generated method stub

        }

        public void afterTextChanged(Editable s) {
        }

        // get the list of predictions in an asynctask
        class GetPlaces extends AsyncTask<String, Void, ArrayList<String>> {

            @Override
            // three dots is java for an array of strings
            protected ArrayList<String> doInBackground(String... args) {
                ArrayList<String> predictionsArr = new ArrayList<String>();

                try {
                    URL googlePlaces = new URL(
                            // URLEncoder.encode(url,"UTF-8");
                            "https://maps.googleapis.com/maps/api/place/autocomplete/json?input="
                                    + URLEncoder.encode(args[0].toString(),
                                            "UTF-8")
                                    + "&types=geocode&language=en&sensor=true&key=import-hash-key-here");

                    URLConnection tc = googlePlaces.openConnection();

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(tc.getInputStream()));

                    String line;
                    StringBuffer sb = new StringBuffer();
                    // take Google's legible JSON and turn it into one big
                    // string.
                    while ((line = in.readLine()) != null) {
                        sb.append(line);
                    }
                    // turn that string into a JSON object
                    JSONObject predictions = new JSONObject(sb.toString());
                    // now get the JSON array that's inside that object
                    JSONArray ja = new JSONArray(predictions
                            .getString("predictions"));

                    for (int i = 0; i < ja.length(); i++) {
                        JSONObject jo = (JSONObject) ja.get(i);
                        // add each entry to our array
                        predictionsArr.add(jo.getString("description"));
                    }
                } catch (IOException e) {

                } catch (JSONException e) {

                }
                // return all the predictions based on the typing the in the
                // search
                return predictionsArr;

            }

            // then our post

            @Override
            protected void onPostExecute(ArrayList<String> result) {
                // put all the information in the list view to display
                Log.d("YourApp", "onPostExecute : " + result.size());
                // update the adapter
                adapter = new ArrayAdapter<String>(getBaseContext(),
                        R.layout.list_item);// show the list view as texts
                // attach the adapter to listView
                listView.setAdapter(adapter);

                for (String string : result) {
                    adapter.add(string);
                    adapter.notifyDataSetChanged();

                }
                next.setClickable(true);
            }

        }

    });