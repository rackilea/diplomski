@Override
public void actionPerformed(final ActionEvent e) {

    System.out.println("Listening..");
    if (e.getSource().equals(button1)) {
        new Thread() {
            @Override
            public void run() {
                int getMarg = cc.getMargin();
                for (int i = 1; i < 20; i++) {
                    getMarg = cc.getMargin();
                    cc.setMargin(getMarg + 1);
                    reValidate();
                    System.out.println(i);

                    try {
                        Thread.sleep(50);
                    } catch (Throwable e) {
                    }

                }
            }
        }.start();

    }

}