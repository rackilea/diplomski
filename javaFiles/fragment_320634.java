lvItem.setOnItemLongClickListener(new OnItemLongClickListener() {

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View v,
                int position, long id) {
            // TODO Auto-generated method stub
                                AlertDialog.Builder adb = new AlertDialog.Builder(
                    YourActivity.this);
            adb.setTitle("Are you sure want to delete this item");
            adb.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog,
                                int which) {
                            // TODO Auto-generated method stub
                            itemArrey.remove(position);
                            itemAdapter.notifyDataSetChanged();


                        }
                    });
            adb.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog,
                                int which) {
                            // TODO Auto-generated method stub
                             dialog.dismiss();

                        }
                    });
            adb.show();

            return false;
        }
    });