categoryList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Log.e("inside" ,"onItemSelected");
                if(i>2) {

                    Collections.rotate(txtItems,4);
                    categoryList.setSelection(2);
                    Log.d("position rotated",""+i);
                    listadapter.notifyDataSetChanged();

                }else if(i<2){
                    Collections.rotate( txtItems,1);
                    categoryList.setSelection(2);
                    listadapter.notifyDataSetChanged();
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            Log.e("inside" ,"onNothingSelected");
            }
        });