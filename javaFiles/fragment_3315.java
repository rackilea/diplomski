@Override
public boolean onOptionsItemSelected(MenuItem item){
    switch (item.getItemId()){
        case android.R.id.home:
            //DO WHAT YOU WANT WHEN YOU HIT UP BUTTON
            //in your case probably finish()
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}