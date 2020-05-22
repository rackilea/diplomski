public boolean onTouch(View v, MotionEvent event) {
                int x = (int)event.getX();
              int y = (int)event.getY();

               switch(event.getActionMasked()) {
                     //touch down so check if finger is on ball
                    case MotionEvent.ACTION_DOWN:
                         //



                    break;

                    case MotionEvent.ACTION_MOVE:
                      //moves the image with the finger
                      if (mImageView25.getX() > 0 && mImageView25.getY() >0) {
                          mImageView25.setX(x + mImageView25.getX());
                          mImageView25.setY(y + mImageView25.getY());

                      }// color square 50 50
                      if (mImageView25.getX() >= 430 && mImageView25.getX()<= 470 && mImageView25.getY() >= 80  && mImageView25.getY() <= 120) { //colorsquare RGBY
                           mImageView25.setVisibility(gone);    

                         } else {

                             }

                      break;

                     case MotionEvent.ACTION_UP: 
                      // touch drop will do things here after drop

                        if (mImageView25.isShown() != true) {//here is what was changed
                              iGone++;//what was changed
                              }  
                         checkIfCorrect();//checking if correct moved after the if statement


            }

                return true;