@Override
    public void paint(Graphics arg0) {
        super.paint(arg0);
        Graphics2D gd = (Graphics2D) arg0;
        if(drawLine){
            gd.setColor(Color.RED);
            gd.drawLine(10, 10, 100, 100);
        }else{
            super.paint(arg0);
        }
    }