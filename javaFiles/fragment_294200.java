searchContentEditText.addTextChangedListener(new TextWatcher()
            {
                public void afterTextChanged(Editable s)
                {

                }
                public void beforeTextChanged(CharSequence s, int start, int count, int after)
                {
                }
                public void onTextChanged(CharSequence s,
                        int start, int before, int count)
                {
                    selection= searchContentEditText.getText().toString().toLowerCase();



                        List newListTwo=new ArrayList();
                        textlength = selection.trim().length();
                        System.err.println("selection" + textlength);
                        newListTwo.clear();
                        for (int i = 0; i < contactList.size(); i++)
                        {
                            // -------------- seach according to the content starts with -------------------------

                            if(firstList.get(i).getContent().toLowerCase().startsWith(selection))
                            {


                                System.err.println("Selection: " + selection);

                                newListTwo.add(firstList.get(i));
                            }
                        }

                        //---------------- Again Call your List View ------------------
                        adapter=new ContactListAdapter(MyActivity.this, newListTwo);
                        setListAdapter(adapter);

                }
            });