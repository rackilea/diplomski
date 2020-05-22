expListView.setOnChildClickListener(new OnChildClickListener() {

    @Override
    public boolean onChildClick(ExpandableListView parent, View view,
            int groupPosition, int childPosition, long id) {

        // selected item

        if(listDataHeader.get(groupPosition).equalsIgnoreCase("Catalog")){
             Intent i = new Intent(MainActivity.this, SingleListItem.class);
             // sending data to new activity
              startActivity(i);
        }

        if(listDataHeader.get(groupPosition).equalsIgnoreCase("My Account"){

                Intent i1 = new Intent(MainActivity.this,CheckHolds.class);
                startActivity(i1);
        }
         if(listDataHeader.get(groupPosition).equalsIgnoreCase("Library Info"){

            Intent i2 = new Intent(MainActivity.this,LibraryHours.class);
            startActivity(i2);
        }

     return false;
    }