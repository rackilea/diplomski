JFrame frame = new JFrame();
Canvas canvas = new Canvas();
canvas.setBackGround(Color.GREEN);
canvas.setOpaque(true); //i'm not sure if canvas is not transparent, i should read api first ^^
frame.add(canvas);
frame.setUndecorated(true);
frame.setVisible(true);