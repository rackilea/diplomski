new DownloadJSON(new DownloadJSON.AsyncCallback() {
    @Override
    public void onComplete(String result) {
        textView.setText(result);
    }
}).execute("www.exampleURL.com/data1");