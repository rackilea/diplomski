Thread t2 = new Thread(new Runnable() {
                        public void run() {
                            try {
                                startButton.setEnabled(false);
                                startButton.setVisible(false);
                                buttonsPanel.setEnabled(false);
                                buttonsPanel.setVisible(false);
                                expText.setText("Listen to the song and give a rating when it finishes.");
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                    t2.start();




                    Thread t1 = new Thread(new Runnable() {
                        public void run() {
                            // code goes here.
                            try {
                                mediaPlayer();
//                               Thread.sleep(5000);


                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                    t1.start();

                    ActionListener taskPerformer = new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            //...Perform a task...

                            resultButtonGroup.clearSelection();
                            startButton.setEnabled(true);
                            startButton.setVisible(true);
                            buttonsPanel.setVisible(true);

                        }
                    };
                    Timer timer = new Timer(stimDuration ,taskPerformer);
                    timer.setRepeats(false);
                    timer.start();