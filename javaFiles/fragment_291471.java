Runnable r = new Runnable() {
    public void run() {
        int i=0;
        try{
            while (i<=100){    
                final int tmpI = i+10;
                SwingUtilities.invokeLater(new Runnable(){ 
                    public void run() {
                        progressBar.setValue(tmpI);
                    }
                });
                Thread.sleep(1000);
                i += 20;
            }
        } catch(Exception ex){
             //nothing
        }
    }
};
Thread t = new Thread(r);
t.start();