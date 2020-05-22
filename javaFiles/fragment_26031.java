// Update space used every 1s
            ActionListener taskQuota = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    quotaDisk.setLabel("Storage used: " + checkVolSize());
                }
            };
            new Timer(1000, taskQuota).start();