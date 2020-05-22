searchText.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence s, int start, int before,
                        int count) {
                    // TODO Auto-generated method stub

                    String searchString = searchText.getText().toString();
                    int textLength = searchString.length();

                    ArrayList<String> searchList = new ArrayList<String>;
                    //searchList.clear(); 

                    for (int i = 0; i < listExample.size(); i++) {
                        Example model = listExample.get(i);
                        String Names = model.getName().toString();
                        if (textLength <= Names.length()) {
                            // compare the String in EditText with Names in the
                            // ArrayList
                            if (searchString.equalsIgnoreCase(Names.substring(
                                    0, textLength)))
                                searchList.add(listExample.get(i));
                        }
                    }

                    ArrayAdapter<Example> ad = new YOUR_ADAPTER(
                            YOUR_CLASS.this, searchList);
                    YOUR_LISTVIEW.setAdapter(ad);
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                        int after) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable s) {
                    // TODO Auto-generated method stub

                }
            });