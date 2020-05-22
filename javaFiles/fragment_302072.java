JPanel jPanel = new JPanel();
jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    System.out.println("mouseClicked");
                }
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    System.out.println("mouseEntered");
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    System.out.println("mouseExited");
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    System.out.println("mousePressed");
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    System.out.println("mouseReleased");
                }
            });