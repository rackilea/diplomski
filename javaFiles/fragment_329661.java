like.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v) {
         Boolean liked = !sp.getBoolean(unique_image_id,false);
            sp.edit().putBoolean(unique_image_id, liked).apply();
            if(liked){
            like.setImageResource(R.drawable.heartfull);
            }else{
              like.setImageResource(R.drawable.heartempty);    
        }
    });