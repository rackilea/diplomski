Frame F=new Frame();
F.setLayout(new FlowLayout());
F.addWindowListener(new WindowAdapter()
    {public void windowClosing(WindowEvent we){System.exit(0);}});
AWTFigur P1=new AWTFigur(new Square(Integer.parseInt(args[0])));
F.add(P1);
AWTFigur P2=new AWTFigur(new Circle(Integer.parseInt(args[1])));
F.add(P2);