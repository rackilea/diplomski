@Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation() * -1;
        ind += notches;
        if(ind < 0) {
            ind = 0;
        }
        else if(ind > 9) {
            ind = 9;
        }
        str = "/resources/" + ind + ".png";
        ChangImage(str);
    }