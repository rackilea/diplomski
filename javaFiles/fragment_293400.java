Timer timer = new Timer((int)time, new ActionListener(){
    public void actionPerformed(ActionEvent event) {
        if (forward == true) {
            forward();
        } else {
            back();
        }
        if (deltax[1] == 10 - length[1]) {
            forward = false;
        } else if (deltax[1] == 0) {
            forward = true;
        }
        draw();
    }
});