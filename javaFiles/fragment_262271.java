OnClickListener childListener;

   public void setOnClickListener(OnClickListener listener) {
       childListener = listener;
   }

   Constructor() {
       super.setOnClickListener(new OnClickListener() {
           public void onClick(View view) {
               //Do what you want
               if(childListener != null) {
                   childListener.onClick(view);
               }
           }
        });
    }