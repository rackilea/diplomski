fb[i][j].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton) e.getSource();
                    int x, y;
                    for (int i = 0; i < 15; i++) {
                        for (int j = 0; j < 15; j++) {
                            if(fb[i][j].equals(b)){
                                x = i;
                                y = j;
                                break;
                            }
                        }
                    }

                    if (x - 1 >= 0) {
                    if (fb[x - 1][y] != null) {
                        fb[x - 1][y].setBackground(Color.RED);
                    }
                    } else if (x + 1 < 15) {
                        if (fb[x + 1][y] != null) {
                            fb[x + 1][y].setBackground(Color.RED);
                        }
                    } else if (y - 1 >= 0) {
                        if (fb[x][y - 1] != null) {
                            fb[x][y - 1].setBackground(Color.RED);
                        }
                    } else if (y + 1 < 15) {
                        if (fb[x][y + 1] != null) {
                            fb[x][y + 1].setBackground(Color.RED);
                        }
                    }

                }
            });