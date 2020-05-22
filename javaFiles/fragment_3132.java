fragmentTransaction.commit();  

Thread thread=  new Thread(){
    @Override
    public void run(){ try { synchronized(this){wait(500);}}catch(InterruptedException ex){ }

        map=frag.getMap();
        System.out.println("MAP OK"+frag.getMap());

    }
};

thread.start();