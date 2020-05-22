new Thread(){
    public void run(){
        long hintPoint = System.currentTimeMillis();
        long nexttickG = System.currentTimeMillis();
        long nexttickL = System.currentTimeMillis();
        long nexttickV = System.currentTimeMillis();
        long ticktimeV = 1000;
        long LogicCap = 60;
        long ticktimeL = 1000/LogicCap;
        short frames = 60;

        while(isRunning){

            if(Main.servbot){
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            GLOBAL_FPS_CAP=(short)Utils.Clamp(GLOBAL_FPS_CAP,1, 333);

            short FramesCap = GLOBAL_FPS_CAP;
            long ticktimeG = 1000/FramesCap;

            if (System.currentTimeMillis()>nexttickG){
                Render();
                long elapsed = System.currentTimeMillis() - hintPoint;
                frames=(short)((long)1000/(Math.max(elapsed,1)));
                hintPoint = System.currentTimeMillis();
                nexttickG+=ticktimeG;
   /*new*/      if( nexttickG < System.currentTimeMillis() ) {
   /*new*/         // major clock skew somehow, reset.
   /*new*/         nexttickG = System.currentTimeMillis() + ticktimeG;
   /*new*/      }
            }

            if (System.currentTimeMillis()>nexttickL){
                GameLoop();
                nexttickL+=ticktimeL;
   /*new*/      if( nexttickL < System.currentTimeMillis() ) {
   /*new*/         // major clock skew somehow, reset.
   /*new*/         nexttickL = System.currentTimeMillis() + ticktimeL;
   /*new*/      }
            }

            if (System.currentTimeMillis()>nexttickV){
                GLOBAL_FPS_HINT = frames;

                nexttickV+=ticktimeV;
            }

            Thread.yield();

        }

    }
}.start();