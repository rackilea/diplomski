// you DO NOT need to inflate a new view. by dialog.setContentView(v); you *replace* your XML file with another layout.

                    // inflating the custom institutional expandable list layout
                    //LayoutInflater li = (LayoutInflater) thisContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    //View v = li.inflate(R.layout.institutional_info_custom_list, null, false);
                    //dialog.setContentView(v);

                    // dont forget to check this line
                    InstitutionalInfoListView = (ListView) dialog.findViewById(R.id.custom_dialog_list); // set a custom id for your list in the layout
                    final MasterDetailArrayAdapter adapter = new MasterDetailArrayAdapter(HomeComune.this, MasterDetailInstitutionalInfoList);         
                    InstitutionalInfoListView.setAdapter(adapter);

                    dialog.show();