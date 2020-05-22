public void onClick(View v) {
     int id = v.getId();

     if (count[id] > 1) {
       count[id]--;
       totalCount--;
       notifyDataSetChanged(); 
       holder.counter.invalidate();
     }
   }
 });