listView.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view,
                        int position, long arg3) {
                    Content  content = (Content ) adapterView
                            .getItemAtPosition(position);
                    //from the content object retrieve the attributes you require.
                }

            });