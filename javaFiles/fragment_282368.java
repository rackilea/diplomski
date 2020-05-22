mWebview.setWebChromeClient(new WebChromeClient() {
         public void onProgressChanged(WebView view, int progress)   
         {
               //Make the bar disappear after URL is loaded, and changes string to Loading...
               Activity activity = getActivity();
               if (activity != null) {
                  activity.setTitle("Loading...");
                  activity.setProgress(progress * 100); //Make the bar disappear after URL is loaded
                  // Return the app name after finish loading
                  if(progress == 100)
                  activity.setTitle(R.string.Fragment1);
                }
             }
         });