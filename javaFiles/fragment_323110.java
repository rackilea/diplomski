private void bindKeyEvents(){
    this.webView.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_SEARCH) {
                if (event.getAction() == KeyEvent.ACTION_UP){
                    Log.d("testApp", "Release");
                    return true;
                }
                if (event.getAction() == KeyEvent.ACTION_DOWN && event.isLongPress()){
                    Log.d("testApp", "Long Press");
                    return true;
                }
                if (event.getAction() == KeyEvent.ACTION_DOWN){
                    event.startTracking();
                    Log.d("testApp", "Press");
                    return true;
                }
            }
            return true;
        }
    }); 
}