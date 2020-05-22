protected void addDelayedFields() {
    Thread t = new Thread( new Runnable() {
        public void run() {
            for(int i=0;i<SOME_LIMIT;i++) {
                synchronized(UiApplication.getEventLock()) {
                    manager.add(new LabelField(i.toString());
                }
                try{
                    Thread.sleep(1000);
                }
                catch(Exception e){ }
            }
        }
    });
    t.start();
}