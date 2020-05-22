@Override
public boolean onOptionsItemSelected(MenuItem item) {
// Handle item selection
switch (item.getItemId()) {
case R.id.about:
startActivity(new Intent(this, About.class));
return true;
case R.id.help:
startActivity(new Intent(this, Help.class));
return true;
default:
    return super.onOptionsItemSelected(item);
}
}