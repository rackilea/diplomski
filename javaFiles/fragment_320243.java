@Override
public boolean onCreateOptionsMenu(Menu menu) {
  super.onCreateOptionsMenu(menu);
  MenuInflater inflater = getMenuInflater();
  inflater.inflate(R.menu.game_menu, menu);
  return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
switch(item.getItemId()) {
  case R.id.new_game :
    Intent intent = new Intent(this, ActivityNewGame.class);
    this.startActivity(intent);
    break;
  case R.id.help:
    Intent intent = new Intent(this, ActivityHelp.class);
    this.startActivity(intent);
    break;
  default:
    return super.onOptionsItemSelected(item);
  }

return true;
}