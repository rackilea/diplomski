final JProgressBar bar = new JProgressBar(0,250000);
    bar.setValue(1000);
    bar.setIndeterminate(false);
    JOptionPane j = new JOptionPane(bar);

    Thread t = new Thread(){
        public void run(){
            for(int i = 1000 ; i < 250000 ; i+=10000){
                bar.setValue(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    };
    t.start();

    final JDialog d = j.createDialog(j,"Expierment X");
    d.pack();
    d.setVisible(true);