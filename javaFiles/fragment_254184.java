p2=new JPanel() {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(Color.BLACK);

        gr.drawLine(10,10,20,20)

    }

}