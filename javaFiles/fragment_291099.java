private BitmapDrawable ball;

protected void onDraw(Canvas c) {  

            Random randLan = new Random();
            int imag = randLan.nextInt(4) + 1;

            int image = 0;
            switch (imag)
                {
                case 1:
                    image = R.drawable.ballgel;
                    ball = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.ballgel);
                    break;

                case 2:
                    image = R.drawable.ballgel;
                    ball = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.ballbl);
                    break;

                case 3:
                    image = R.drawable.ballgel;
                    ball = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.ballgrue);
                    break;

                case 4:
                    image = R.drawable.ballgel;
                    ball = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.ballrot);
                    break;
                    }


            if (x<0) {
                x = this.getWidth()/2;
                y = this.getHeight()/3;
            } 

                else {
                    x += xVelocity;

                        if ((x > this.getWidth() - ball.getBitmap().getWidth()) || (x < 0)) {
                            boolean continueAnimation = false;
                        }
                }

            c.drawBitmap(ball.getBitmap(), x, y, null);  

            if(continueAnimation) 
            {
                h.postDelayed(r, FRAME_RATE);
            }   

            else {
                    x = this.getWidth()-ball.getBitmap().getWidth();
            }

        }