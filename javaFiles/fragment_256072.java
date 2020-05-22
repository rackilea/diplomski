@Override
    public void paint(Graphics g) {
        g.drawString("Output of paint method",20,20);
        myMethod(g); //calling myMethod
    }

    public static void myMethod(Graphics g) {
        g.drawString("Output of myMethod",20,40);
    }