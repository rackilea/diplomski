public class DrawPoints
{
    Frame f;
    KeyBoard key;
    Mouse mouse;
    Paint c;

    public void GUI()
    {
        f = new Frame("DrawPoints");
        f.setSize(300, 300);

        mouse = new Mouse();


        c = new Paint(mouse);
        c.setSize(300, 300);
        c.setBackground(Color.WHITE);
        c.addMouseListener(mouse);
        c.addMouseMotionListener(mouse);

        key = new KeyBoard();
        c.addKeyListener(key);



        f.add(c);
        f.pack();
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}}