MenuItem item = menu.findItem(R.id.spinnerr);
 spinner = (Spinner) MenuItemCompat.getActionView(item);

 //rest of your codes

spinner.setAdapter(spinnerAdapter);

if(this.myBundle != null){
 spinner.setSelection(myBundle.getInt("spinner", 0));
}