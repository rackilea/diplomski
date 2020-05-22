pnl2.setVisible(true);
                javax.swing.Timer timer =
                    new javax.swing.Timer(3000, event -> {
                        pnl2.setVisible(false);
                    });
                timer.setRepeats(false);
                timer.start();