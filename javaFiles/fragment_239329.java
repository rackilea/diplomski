ExpandList = (ExpandableListView) findViewById(R.id.expandableListView);
                        ExpListItems = SetStandardGroups(da.queryName());
                        ExpAdapter = new ExpandListAdapter(MainActivity.this, ExpListItems);

and this is my method for fiil that list:





      public ArrayList<ExpandListGroup> SetStandardGroups(Cursor crsr) {
                ArrayList<ExpandListGroup> list = new ArrayList<ExpandListGroup>();
                ArrayList<ExpandListChild> list2;
                Cursor c = crsr;
                if (c.moveToFirst()) {
                    do {
                        String English = c.getString(c.getColumnIndex("English"));
                        String Farsi = c.getString(c.getColumnIndex("Farsi"));
                        ExpandListGroup gru1 = new ExpandListGroup();
                        gru1.setName(English);
                        ExpandListChild ch1_1 = new ExpandListChild();
                        ch1_1.setName(Farsi);
                        ch1_1.setTag(null);
                        list2 = new ArrayList<ExpandListChild>();
                        list2.add(ch1_1);
                        gru1.setItems(list2);
                        list.add(gru1);
                    } while (c.moveToNext());
                }
                c.close();

                return list;
            }