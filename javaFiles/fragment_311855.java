Shape[] shapes = new Shape[5];
shapes[1] = new Rectangle(180,390,50,8,0);
shapes[2] = new Circle (199,365,10,0);

GameView view = new GameView(shapes);
MyKeyListener listener = new MyKeyListener(shapes);