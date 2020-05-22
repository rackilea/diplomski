@Override
 public boolean onOptionsItemSelected(MenuItem item) {
     switch (item.getItemId()) {

        case android.R.id.home:
            //Close current activity
            finish();
        return true;    

         default:
             return super.onOptionsItemSelected(item);
     }
}