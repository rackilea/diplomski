class MyButton extends JButton {

        Color color = Color.GREEN;

        public MyButton(ImageIcon icon) {
            super(icon);
            setMargin(new Insets(0, 0, 0, 0));
            setFocusable(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setModel(new DefaultButtonModel());
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    color=Color.RED;
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    color=Color.BLUE;
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    color=Color.BLUE;
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    color=Color.GREEN;
                }
            });

        }

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(color);
            g.fillOval(0, 0, this.getWidth(), this.getHeight());
            super.paintComponent(g);

        }

    }