void setListenerForGroup(ViewGroup group) {
   int count = group.getChildCount(); <------- more efficient
   for(int i = 0; i < count; i++) {
       View v = group.getChildAt(i);
       if (v instanceof Button)
           v.setOnClickListener(this);
       else if (v instanceof ViewGroup)
           setListenerForGroup((ViewGroup)v);
   }
}