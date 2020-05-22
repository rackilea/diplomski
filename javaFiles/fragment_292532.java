public void game (Button[] temp) {
        Thread check = new Thread(new startGame(temp));
        check.start();
    }
    class startGame implements Runnable {
        private Button[] temp
        startGame(Button[] temp) {
            this.temp=temp;
        }
        public synchronized void run() {
            if (temp[0].getDrawingCacheBackgroundColor() == temp[1].getDrawingCacheBackgroundColor() )
            {
                temp[0].setVisibility(View.INVISIBLE);
                temp[1].setVisibility(View.INVISIBLE);
            } 
        }
    }