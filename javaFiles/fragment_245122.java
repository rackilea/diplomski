save.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){

             store(bitmap, currentImage);
            //after saving image call refreshmedia()
             refreshMedia();
        }