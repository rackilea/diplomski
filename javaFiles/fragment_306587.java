public void addFooterView(View v, boolean clickable) {
   if(!clickable){
         v.setClickable(false);
         v.setFocusable(false);
         v.setEnabled(false);
    }
   mListView.addFooterView(v);
}