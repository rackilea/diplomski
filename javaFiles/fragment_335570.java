startButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent ae) {
        BufferedImage out = deleteVerticalSeam(input);
        System.out.println("Do Something Clicked");
        toPaint[0]=out;
        repaint();    
    }
});