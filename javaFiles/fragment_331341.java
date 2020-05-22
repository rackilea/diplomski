Json Array
            listView = (ListView) findViewById(R.id.list);
            adapterAirlines = new AirlinesAdapter(this, airlinesList);
            listView.setAdapter(adapterAirlines);

            pDialog = new ProgressDialog(this);

            // Showing progress dialog before making http request
            pDialog.setMessage("Loading...");
            pDialog.show();

            // Listview OnItemClickListener
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // getting values from selected ListItem
                    String name = ((TextView) view.findViewById(R.id.name))
                            .getText().toString();
                    String phone = ((TextView) view.findViewById(R.id.phone))
                            .getText().toString();
                    String site = ((TextView) view.findViewById(R.id.site))
                            .getText().toString();
                    String logoURL = String.valueOf(((ImageView) view.findViewById(R.id.logoURL)));

                    // Starting single contact activity
                    Intent in = new Intent(getApplicationContext(),
                            SingleContactActivity.class);
                    in.putExtra(TAG_NAME, name);
                    in.putExtra(TAG_PHONE, phone);
                    in.putExtra(TAG_SITE, site);
                    in.putExtra(TAG_LOGO, logoURL);
                    startActivity(in);
                }
            });

            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view,
                                               int position, long id) {
                    ImageView button = (ImageView) view.findViewById(R.id.favorite_button);

                    String tag = button.getTag().toString();
                    if (tag.equalsIgnoreCase("grey")) {
                        sharedPreference.addFavorite(MainActivity.this, airlinesList.get(position));
                        Toast.makeText(MainActivity.this,
                                MainActivity.this.getResources().getString(R.string.add_favr),
                                Toast.LENGTH_SHORT).show();

                        button.setTag("red");
                        button.setImageResource(R.drawable.heart_red);
                    } else {
                        sharedPreference.removeFavorite(MainActivity.this, airlinesList.get(position));
                        button.setTag("grey");
                        button.setImageResource(R.drawable.heart_grey);
                        Toast.makeText(MainActivity.this,
                                MainActivity.this.getResources().getString(R.string.remove_favr),
                                Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
            });