final List<GameObject> list = initList();//some initialization
t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            myMultipurposeMethod(list);
        }
    });

 t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            myMultipurposeMethod(list);
        }
    });
 t1.start();
 t2.start();