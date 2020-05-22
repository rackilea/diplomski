Runnable task = new Runnable() {
        public void run() {
            try {
                throw new RuntimeException("foo");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };