class MyButton extends JButton {

        public MyButton(ImageIcon icon) {
            super(icon);
            setMargin(new Insets(0, 0, 0, 0));
            setFocusable(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setModel(new DefaultButtonModel());
            setCursor(new Cursor(Cursor.HAND_CURSOR));

        }

        public void paintComponent(Graphics g) {
            g.setColor(Color.green);
            g.fillOval(0, 0, this.getWidth(), this.getHeight());
            super.paintComponent(g);

        }

    }