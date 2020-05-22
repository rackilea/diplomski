yourListView.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "delete item in position : " + arg2, Toast.LENGTH_SHORT).show();
                return false;
            }
        });