final boolean firstClick = false;
    img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(firstClick){
                    img1.setImageResource(R.mipmap.pause_icon);
                } else{

                    img1.setImageResource(R.mipmap.play_icon);
                 } 
            firstClick = !firstClick;
            }
        });