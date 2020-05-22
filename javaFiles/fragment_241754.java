Menu menu;

@Override
public boolean onCreateOptionsMenu( Menu menu ) {
  getSupportMenuInflater().inflate( R.menu.my_menu, menu );
  this.menu = menu;     

  return true;
}