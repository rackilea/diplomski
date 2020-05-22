public Main() {
    Random g = new Random();

    //setPreferredSize(...); // commented this line

    for (int i = 0; i < radius.length; i++) {
        radius[i] = g.nextInt(50) + 1;
        xArray[i] = g.nextInt(250) + 1;
        yArray[i] = g.nextInt(150) + 1;
    }
}

public void paintComponent(Graphics page) {
        ...
}

public static void main(String[] args) {
    JFrame frame = new JFrame("Circles");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setSize(300, 200); // added this line

    frame.getContentPane().add(new Main());

    // frame.pack(); // commented this line

    frame.setVisible(true);
}