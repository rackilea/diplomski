bar.addExpandListener(new ExpandAdapter() {

    @Override
    public void itemCollapsed(ExpandEvent e) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(250);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Display.getDefault().asyncExec(new Runnable() {
                    public void run() {
                        layout();

                    }
                });
            }
        }).start();
    }

    @Override
    public void itemExpanded(ExpandEvent e) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(250);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Display.getDefault().asyncExec(new Runnable() {
                    public void run() {
                        layout();

                    }
                });
            }
        }).start();
    }
});