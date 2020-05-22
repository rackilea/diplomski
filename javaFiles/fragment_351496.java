public void callNumber(View view) {
    if( view != null ) { // view is the button tapped
        View parent = view.getParent(); // this should be the LinearLayout
        if( parent instanceof LinearLayout ) {
            TextView unItemVal = (TextView) ((LinearLayout)parent).findViewById(R.id.useful_nums_item_value);
            if( unItemVal != null ) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String phoneNumber = unItemVal.getText().toString();
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);
            }
        }
    }
}