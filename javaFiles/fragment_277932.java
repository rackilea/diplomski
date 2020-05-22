Thread mover = new Thread() {
        @Override
        public void run() {
            Roboter.movement1();
        }
    }
mover.start();