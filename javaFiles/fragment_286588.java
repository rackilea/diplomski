private View.OnClickListener displayPainting = new View.OnClickListener() {
         public void onClick(View btn) {
    ....
             imgIntent.putExtra("image_id", btn.getId());
             startActivity(imgIntent);

         }
    };