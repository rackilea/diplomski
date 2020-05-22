Color color = Color.WHITE;
Random random = new Random();
....
Timer timer = new Timer(1000, new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent arg0) {
        int r1=random.nextInt(255);
        int r2=random.nextInt(255);
        int r3=random.nextInt(255);
        color = new Color(r1, r2, r3);
        repaint();
    }
});
timer.start();
...
public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(color);
    ...
}