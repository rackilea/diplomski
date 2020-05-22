new Thread(new Runnable() {
        private int lastNum = 25;
        private char lett;
        private char lettUp;

        Random r = new Random();


        @Override
        public void run() {

            Thread th1 = new Thread();
            ta.appendText("\n");
            for(int i = 1; i <= lastNum; i++){
                int rN = r.nextInt(25) + 1;
                ta.appendText((lastNum - rN) + " ");
            }

            Thread th2 = new Thread();
            ta.appendText("\n\n");
            for(int i = 1; i <= 25; i++){
                char c = (char) (r.nextInt(26) + 'a');
                lett = c;
                ta.appendText(lett + " ");
            }

            Thread th3 = new Thread();
            ta.appendText("\n\n");
            for(int i = 1; i <= 25; i++){
                char c = (char) (r.nextInt(26) + 'A');
                lettUp = c;
                ta.appendText(lettUp + " ");
            }

            th1.start();
            try{
                th1.join(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            th2.start();
            try{
                th1.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            th3.start();
            try{
                th1.join();
                th2.join();
                th3.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }).start();