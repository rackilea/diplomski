@Override
protected void onCreate(Bundle savedInstanceState) {
   ...
   Intent intent = getIntent();
   if(intent != null) {
      int position = intent.getIntExtra(EXTRA_POSITION, 0);
      viewPager.setCurrentItem(position);
   }
}