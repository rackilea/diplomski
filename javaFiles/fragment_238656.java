if(Function.isNetworkAvailable(getApplicationContext()))
{
    DownloadNews newsTask = new DownloadNews(this);
    newsTask.execute(); // <-
}else{
    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
}