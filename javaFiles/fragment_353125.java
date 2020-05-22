@Override
public boolean onOptionsItemSelected(MenuItem item) {
  if(item.getItemId() == R.id.bookmark){
    item.setChecked(!item.isChecked());
    item.setIcon(item.isChecked() ? R.drawable.bookmark : R.drawable.nobookmark);
    return true;
  }
  return false;
}