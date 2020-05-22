@Override
            public void actionPerformed(ActionEvent ae) {

                int playersSelected  = 0;

                switch (finalI) {
                    case 0:

                        playersSelected = 2;
                        break;
                    case 1:

                        playersSelected = 3;

                        break;
                    case 2:

                        playersSelected = 4;

                        break;
                    case 3:

                        break;
                }
                gameWindow.remove(mainMenu);
                gameWindow.add(buildPlayersPanel(playersSelected));
                gameWindow.revalidate();
                gameWindow.repaint();
                System.out.println(playersSelected);
            }