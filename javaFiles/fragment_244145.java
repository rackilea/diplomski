@Override
public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
        final Intent intent = getParentActivityIntent();
        if(intent != null){
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        }else{
          //Do some error handling.
        }
        onBackPressed();
        return true;
    }
    return super.onOptionsItemSelected(item);
}