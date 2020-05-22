if (i == 1 ) {
            btncounter.setText("1");
             startTime = System.currentTimeMillis();
            int x1 = (int) buttongame1.getX();
            int y1 = (int) buttongame1.getY();
             buttongame1.setX(r.nextInt(screenHeight - buttongame1.getWidth()));
             buttongame1.setY(r.nextInt(screenHeight - buttongame1.getHeight()));

            start_time.setX((x1));
            start_time.setY(y1);
   }