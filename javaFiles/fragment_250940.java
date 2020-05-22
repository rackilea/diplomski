addText(cmd, "1");
  new LazyAction(300){

        @Override
        public void run() {
           addText(cmd, "2");
        }
  }