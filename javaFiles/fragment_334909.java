public movingButton() {

    [...]

    MouseAdapter myMouseAdapter = new MouseAdapter(){
        int mouseClickedPosX = 0;
        int mouseClickedPosY = 0;

        @Override
        public void mousePressed(MouseEvent E){
            mouseClickedPosX = E.getX();
            mouseClickedPosY = E.getY();
        }
        @Override
        public void mouseDragged(MouseEvent E){
            int X = E.getX() + button.getX() - mouseClickedPosX;
            int Y = E.getY() + button.getY() - mouseClickedPosY;
            button.setBounds(X, Y,150,40);
        }
    };

    button.addMouseListener(myMouseAdapter);
    button.addMouseMotionListener(myMouseAdapter);
}