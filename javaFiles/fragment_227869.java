Thread t = new Thread() {
    public void run() {
        int counter = 0 ;
        for (int i = 0; i < 2000000; i++) {
            counter++;
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    label.setText(Integer.toString(counter));
                }
            });
        }
    }
};

t.start();