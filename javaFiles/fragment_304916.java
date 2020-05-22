@Override
      public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            WebView.setVisibility(View.GONE);**hide the webview when an error occured**
            Intent intent = new Intent(MainActivity.this, ErrorActivity.class);
            startActivity(intent);
            finish();
        }