ImageIcon bg;

public Jadmin() {

    setSize(800,500);

    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setUndecorated(true);

    setLocationRelativeTo(null);

    JLabel jl=new JLabel();

    bg = new ImageIcon("IMAGE_PATH");
    jl.setIcon(bg);
    jl.setIconTextGap(-IMAGE_WIDTH);
    jl.setOpaque(true);
    jl.setLayout(null);

    add(jl);

    jl.setText("hadsffffffffffffffffffi");

    setVisible(true);
enter code here
   }