new AirLineListRetriever(
            new AirLineListRetriever.AirLineListResponse() {
                @Override
                public void processFinish(List<Airline> airlines) {

                    String selectedAirLine = null;
                    airlineList = airlines;

                    Log.d("EndRetrieve", "Completed the retrieve");

                    // sort the airline list
                    Collections.sort(airlineList, new Comparator<Airline>() {
                        @Override
                        public int compare(Airline airline, Airline t1)
                        {
                            Airline airline1 = (Airline) airline;
                            Airline airline2 = (Airline) t1;
                            return airline1.airlineName.compareToIgnoreCase(airline2.airlineName);

                        }

                    });

                    final ArrayList airlineArrayList = new ArrayList();

                    //copy the airline list to an array to populate the autoCompleteTextView
                    for (int i=0; i < airlineList.size(); i++){
                        airlineArrayList.add(airlineList.get(i).airlineName);
                    }

                    progressDialog.dismiss();

                    acAirlines = (AutoCompleteTextView) findViewById(R.id.autoCompleteAirLines);
                    acAirlines.setVisibility(View.VISIBLE);
                    //acAirlines.setThreshold(4);

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String> (AddFlightActivity.this, android.R.layout.simple_list_item_1, airlineArrayList);
                    acAirlines.setThreshold(2);
                    acAirlines.setAdapter(adapter);

                    acAirlines.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {

                            String selectedAirLine = adapter.getItem(index);
                            int position = airlineArrayList.indexOf(selectedAirLine);
                            String alIataCode = airlineList.get(position).iataCode;
                            Log.d("ALCodePrint", selectedAirLine + " " + alIataCode);
                            alCode.setText(alIataCode);
                            alCode_Set = true;
                            extFunctions.hideKeyboard(AddFlightActivity.this);
                        }

                    });

                }
            }, this.getApplicationContext()
    ).execute();