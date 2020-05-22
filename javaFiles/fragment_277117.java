public void runGameLoop()
{
    Timer timer = new Timer(20, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            update();
            render();
        }    
    });
    timer.start();
}