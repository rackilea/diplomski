public class Window extends JFrame{

    private BufferStrategy bs;
    private Planete plan;
    private JPanel panelDroite = new JPanel();
    private JPanel panelGauche = new JPanel();
    final JButton btn = new JButton("yolo");
    final JButton btn2 = new JButton("yolo 2");

    public Window(String name, Planete p){
    this.setTitle(name);                    //titre de fenetre
    panelDroite.setSize(new Dimension(Constante.longueur ,Constante.largeur));              //change la taille
    this.setSize(1600,900);
    this.setLocationRelativeTo(null);           //place au centre
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //quitte avec la croix
    this.setResizable(false);               //empeche resize
    organisageFenetre();

    this.setVisible(true);                  //rend visible

    //this.setLayout(new BorderLayout());

    plan = p;

    }

    //Créer un update

    public void organisageFenetre(){
        //panelGauche.add(btn);
        //panelGauche.add(btn2);
        this.add(panelDroite);
        //this.add("West",panelGauche);
    }

    public void paintComponent()
    {
    //dessine toute la fenetre
    Graphics g = null; //pointeur de l'outil de dessin
        try{
        g = (Graphics)panelDroite.getGraphics(); //recupere l'outil de dessin de la fenetre de dessin
        if(plan != null)
            plan.draw(g);
        }
        finally
        {
            panelDroite.repaint();
            g.dispose(); //termine l'utilisation de l'outil de dessin
        }
    }

}