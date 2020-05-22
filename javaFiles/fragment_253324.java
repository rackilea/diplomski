for (int i = 0; i < numDisplay; i++) {
            try {
              synchronized (mLock) {
                while (!running) {
                  mLock.wait();
                }
              }
            } catch(InterruptedException e) {           
               //do nothing just continue
            }

            double x = Math.random();
            double y = Math.random();
            numEstimation++;
            if (x * x + y * y < 1) {
                numTouchCircle++;
            }
        }
        System.out.println(numEstimation);
        System.out.println(numTouchCircle);
        estiPi = ((double) numTouchCircle / numEstimation) * 4;
        estiPiLabel.setText(String.valueOf(estiPi));