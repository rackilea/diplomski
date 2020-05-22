public void actionPerformed(ActionEvent e) {
                    LevelNum += 1;
                    System.out.println(LevelNum);
                    // Introduction
                    if (LevelNum == 1) {
                        jLabel1.setText("level1");
                    }
                    if (LevelNum == 2) {
                        jLabel1.setText("level2");
                    }
                    if (LevelNum == 3) {
                        jLabel1.setText("level3");
                    }

                }