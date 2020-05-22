public void onClick(DialogInterface dialog,
                                int id) {

                            //This is the input I can't get text from
                            EditText inputTemp = (EditText) view.findViewById(R.id.search_input_text);
                            //query is of the String type
                            query = inputTemp.getText().toString();
                            newQuery();
                            getJSON newData = new getJSON();
                            newData.execute("Test");
                        }