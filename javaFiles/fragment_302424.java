public void runOnBackground(){
    new Thread(new Runnable() {
        @Override
        public void run() {
            while(true) {
                String item = getItemFromSomwhere();
                addItemToList(item);
            }
        }
    }).start();
}