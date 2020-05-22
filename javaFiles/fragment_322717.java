new Timer(100, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    long diff = System.currentTimeMillis() - start_time;
                    icon.getSvgUniverse().setCurTime(diff % (10 * 1000));
                    try {
                        icon.getSvgUniverse().updateTime();
                    } catch (SVGException ex) {
                        ex.printStackTrace();
                    }
                    icon.paintIcon(null, g2, 0, 0);
                    //or repaint it somehow!
                }
            }).start();