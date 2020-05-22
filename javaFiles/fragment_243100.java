public void btnClick(View view) {
    TextView tv = (TextView)view;
    int id = tv.getId();
    if(id==R.id.one) {
        tv.setText("One Clicked");
    } else if(id==R.id.two){
        tv.setText("Two Clicked");
    }
}