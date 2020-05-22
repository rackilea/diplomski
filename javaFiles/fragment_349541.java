private SharedClickListener sharedListener = new SharedClikListener();

private class MovieArrayAdapter extends ArrayAdapter<Movie>
{
    public MovieArrayAdapter()
    {
        super(getApplicationContext(), R.layout.profiles_item, profilesList);
    }//cons

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
                    //you should build your own views here and fill them with
                    //a profile object, here I use super to compile the example
                    View view = super.getView(position, convertView, parent );
                    view.setOnClickListener( sharedListener );
        return view;
    }//met
}//inner class

private class ItemClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), ((your view class)v).getProfile().getCardNumber(), Toast.LENGTH_SHORT).show();
    Log.d("cardNumber",((your view class) v).getProfile().getCardNumber()); 
        }// met
}//inner class