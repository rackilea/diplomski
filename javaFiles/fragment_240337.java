if(key == KeyEvent.VK_UP)
{
    comp.setY(y++);
    // You may need to force a repaint here
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            comp.setY(y--);
            // You may need to force a repaint here
        }
    });
    timer.setRepeats(false);
    timer.start();
}