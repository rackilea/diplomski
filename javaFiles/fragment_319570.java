// ---
        btnExample.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        btnExampleActionPerformed(evt);
                    } // run()
                }).start();
            }
        });
    // ---