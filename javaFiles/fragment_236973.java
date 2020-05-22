scrollViewMain.setOnTouchListener(new View.OnTouchListener() {
            float xCoor;
            float yCoor;
            float oldX;
            float oldY;

            View circle = findViewById(R.id.circle);
            long initialTime = 0;
            long endTime = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) 
            {
                System.out.println("TOUCHED");

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (initialTime == 0) {
                        initialTime = System.currentTimeMillis();
                    } else {
                        endTime = System.currentTimeMillis();
                        diff = endTime - initialTime;
                        initialTime = endTime;

                        xCoor = event.getX();
                        yCoor = event.getY();
                    }

                    if ((diff > 3000)) {

                        circle.setX(oldX);
                        circle.setY(oldY);

                        circle.setVisibility(VISIBLE);
                        oldX = xCoor;
                        oldY = yCoor;
                    } else if (diff < 3000) {
                        circle.setVisibility(View.INVISIBLE);
                        circle.setX(oldX);
                        circle.setY(oldY);
                        oldX = xCoor;
                        oldY = yCoor;
                    }
                    if ((xCoor > 1000) && (yCoor > 1800)){
                        v.scrollBy(0, 300);
                    }

                }
                return false;
            }
        });