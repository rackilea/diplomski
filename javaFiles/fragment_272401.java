public static void main(String[] args) {
        JFrame theFrame = new JFrame("Testing catess...");
        theFrame.setSize(400, 400);
        Frame fr = new Frame();
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.add(fr, BorderLayout.CENTER);
        theFrame.setVisible(true);
        Frame.setWorkFrame(fr);
    }