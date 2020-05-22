@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
       case R.id.copyid:

        int i = viewPager.getCurrentItem();
        String msgs= i>=0?list.get(i):"";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,msgs);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent,"Share Via"));
        break;


}