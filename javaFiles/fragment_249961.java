YourAsyncTask yourTask = new YourAsyncTask();
yourTask.execute();
yourTask.setOnFinishListener(new YourAsyncTask.OnFinishListener(){
    @Override
    public void onFinish(YourReturnType result){
        // Retrieve your returned value from result
        // And if mMap is ready, perform map actions
    }
});