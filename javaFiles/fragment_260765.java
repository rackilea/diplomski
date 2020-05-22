private static final Color[] clrs = {Color.red,Color.blue};

private final Random rand = new Random();

private Color background = clrs[rand.nextInt(clrs.length)];

// ...

public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(background);
    g2.fillRect(60, 50, 200, 200);  
}

// ...

    b.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (b.getBackground().equals(background)) {
                tf.setText(String.valueOf(count++));
            } else {
                tf.setText("Sorry your guess was wrong");       
            }

            background = clrs[rand.nextInt(clrs.length)];
            repaint();
        }
    });

    // Do the same for the other ActionListener...