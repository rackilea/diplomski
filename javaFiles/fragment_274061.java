@Override
protected void onPostExecute(HtmlPage htmlPage)
{
    Log.d(MainActivity.ASYNC_TASK_TAG, "onPostExecute() called");
    if (htmlPage.getHtmlDocument() != null){
       return;
    }

    setHtmlPage(htmlPage);
}