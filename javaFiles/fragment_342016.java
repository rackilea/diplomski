fab_play_pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                int resId = (Integer) view.getTag();

                   if(resId == R.drawable.play){
                      //your code
                      //change background for pause
                   }
                  else if(resId == R.drawable.pause)
                   {
                      //your code
                      //change background for play
                   }
                }
            });