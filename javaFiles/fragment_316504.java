if (v == findViewById(R.id.RadioAuction)){
LinearLayout ShowPrice = (LinearLayout)findViewById(R.id.LayoutStartPrice);
    ShowPrice.setVisibility(View.VISIBLE);

    //Display reserve price
    LinearLayout ShowReservePrice = (LinearLayout)findViewById(R.id.LayoutReservePrice);
    ShowReservePrice.setVisibility(View.VISIBLE); 
}