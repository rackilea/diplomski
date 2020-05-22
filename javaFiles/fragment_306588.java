public void addFooterView(View v, boolean clickable) {
   if(!clickable){
         v.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            return;
        }
    });
    }
   mListView.addFooterView(v);
}