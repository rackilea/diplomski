searchBox.addTextChangedListener(new TextWatcher() {

                 public void onTextChanged(CharSequence s, int start, int before, int count) {
                   //get the text in the EditText
                    searchString=searchBox.getText().toString();
                    textLength=searchString.length();
                   searchResults.clear();

                   for(int i=0;i<songsList.size();i++)
                   {
                   playerName=songsList.get(i).get("title").toString();
                  System.out.println("player name "+playerName);
                  if(textLength<=playerName.length()){
                  //compare the String in EditText with Names in the ArrayList
                    if(searchString.equalsIgnoreCase(playerName.substring(0,textLength))){
                    searchResults.add(songsList.get(i));
                    System.out.println("the array list is "+songsList.get(i));
                    adapter=new LazyAdapter(Home.this, searchResults);   

                     list.setAdapter(adapter);
                    }

                      }


                   }
                   if(searchResults.isEmpty()){
                       Toast toast= Toast.makeText(getApplicationContext(), 
                                  "No Items Matched", Toast.LENGTH_SHORT);  
                                  toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                                  toast.show();
                   }
                   adapter.notifyDataSetChanged();
                 }

                 public void beforeTextChanged(CharSequence s, int start, int count,
                     int after) {
                 System.out.println("before changed");

                   }

                   public void afterTextChanged(Editable s) {


                                               System.out.println("after changed");
                   }
                  });