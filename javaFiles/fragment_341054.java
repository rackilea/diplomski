@Override
        public void onCreate(Bundle savedInstanceState) {

        ......
        ..
        ..
        String flag = String.valueOf(getIntent().getStringExtra("Flag"));

        if(flag.equalsIgnoreCase("optionone")){

            String topHtml = this.getString(R.string.top_content);
            String bottomHtml = this.getString(R.string.bottom_content);

            TextView titleText = (TextView) findViewById(R.id.title_text);
            titleText.setText(R.string.Hearing_Test);


        }else if(flag.equalsIgnoreCase("optiontwo")){
            String topHtml = this.getString(R.string.top_content);
            String bottomHtml = this.getString(R.string.bottom_content);
        }else{
    }
        .....
        ...
        ...
        if(flag.equalsIgnoreCase("optionone")){
            setResult(RESULT_OK);
        }
        ....
}