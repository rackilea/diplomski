String choice1 =  "-Select Your Choice-";
 allNames.add(choice1);     
 JSONArray array = jsonObject.getJSONArray("Spinner value");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject job = array.getJSONObject(i);
                    String name = job.getString("spinner_data");
                    allNames.add(name);

                }

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                        (MainActivity.this, android.R.layout.simple_spinner_item, allNames);


                spinner.setAdapter(dataAdapter);