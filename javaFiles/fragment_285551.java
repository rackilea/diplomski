getSupportFragmentManager()
  .addOnBackStackChangedListener(new OnBackStackChangedListener(){
      @Override
      public void onBackStackChanged() {
        updateToolbarUp();
      }
  });

public void updateToolbarUp(){
  boolean showUp = getSupportFragmentManager().getBackStackEntryCount() > 0;
  getSupportActionBar().setDisplayHomeAsUpEnabled(showUp);
}