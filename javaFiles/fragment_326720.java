LinearLayout container = (LinearLayout)findById(R.id.list_container)
for(int i = 0; i < 5; i++){

   // inflate and set up your layout mView
   // (...)

   container.addView(mView);
}