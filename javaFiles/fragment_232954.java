int loadedPercentage = 0;
 boolean loaded = false;
 mathView.setWebChromeClient(new WebChromeClient(){
     public void onProgressChanged(WebView view, int newProgress) {
         super.onProgressChanged(view, newProgress);
         loadedPercentage = newProgress;
         if(newProgress==100) {
             //When the loading is 100% completed; todo
             loaded = true;
             Toast.makeText(getContext(), newProgress + "LOADED COMPLETELY", Toast.LENGTH_SHORT).show();
         }
     }
 });