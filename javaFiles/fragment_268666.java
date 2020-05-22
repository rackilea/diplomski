buttonConfirmar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        restClient = new RestClient<>(MyObject.class, new AsyncFinishedCallback(){
    @Override
    public void onAsyncFinished(){
            new WhenWebServiceConnectionFinished().execute();
    }
});

        restClient.execute(getString(R.string.WebServiceURL));