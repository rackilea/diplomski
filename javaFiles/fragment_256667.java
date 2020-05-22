MyRestClientClass mRestClientClass = new MyRestClientClass();

//instantiate the rest client inside
mRestClientClass.initializeRestClient();

//to call your updateMap for example after a button click 
yourButton.setOnClickListener(new OnClickListener() {
    //note that this works the same way as the Retrofit callback
    public void onClick(View v) {
        //call your web service
        mRestClientClass.updateMethod();
    }
});