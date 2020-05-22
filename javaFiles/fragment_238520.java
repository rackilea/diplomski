mExpandableList.setOnChildClickListener(new OnChildClickListener() {

   @Override
   public boolean onChildClick(ExpandableListView parent, View v,int groupPosition, int childPosition, long id) {

      /* You must make use of the View v, find the view by id and extract the text as below*/

      TextView tv= (TextView) v.findViewById(R.id.childTextView);

      String data= tv.getText().toString();                 

      return true;  // i missed this
    }
});