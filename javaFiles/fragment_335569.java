startButton.addActionListener(new ActionListener() {
    BufferedImage out = input;

    @Override
    public void actionPerformed(ActionEvent ae) {
        out = deleteVerticalSeam(out);
        System.out.println("Do Something Clicked");
        toPaint[0]=out;
        repaint();    
    }
});