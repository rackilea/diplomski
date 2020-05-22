public void someServiceMethod(){
    new Thread(new Runnable(){
            public void run(){
                //do your stuff
            }
        }
    ).start();
}