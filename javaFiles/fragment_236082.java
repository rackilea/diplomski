fav_up_btn = (Button)findViewById(R.id.fav_up_btn);
fav_up_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {       
        fav_up_btn.setBackgroundResource(R.drawable.fav_dwn_btn);
        Log.d("mylog","fav_up_btn is clicked");
    }
});