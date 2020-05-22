String[] activities = {"Foods","Entertainment","Movies","Other"};

listview.setAdapter(...);

Context mContext = this;

listview.setOnItemClickListener(new OnItemClickListener() {
   @Override
   public void onItemClick(AdapterView<?> a, View v, int position, long id) {
   if(position == 0) {
      mContext.startActivity( new Intent(Main.this, Foods.class));
   } else if (position == 1) {
      mContext.startActivity( new Intent(Main.this, Entertainment.class));
   } else if (position == 2) {
      mContext.startActivity( new Intent(Main.this, Movies.class));
   } else if (position == 3) {
      mContext.startActivity( new Intent(Main.this, Other.class));
   }
}