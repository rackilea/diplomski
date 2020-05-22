@Override
protected void onPostExecute(HtmlPage htmlPage)
{
    if (htmlPage.getHtmlDocument() != null){
       Log.d(MainActivity.ASYNC_TASK_TAG, "onPostExecute() called");
       setHtmlPage(htmlPage);
    }
}