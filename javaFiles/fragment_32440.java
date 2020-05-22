new Thread(new Runnable() {
        @Override
        public void run() {
            // do something long here
            YourActivity.this.doSomething();
        }
    })