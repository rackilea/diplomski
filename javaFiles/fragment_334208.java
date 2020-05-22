class Interfaz extends JFrame {
    private Container contenedorJuego, contenedorMenu, mainPane;
    private JButton showC;

    public Interfaz() {
        super("MEGA 2048");
        showC = new JButton("Switch);
        contenedorJuego = new JPanel();
        contenedorMenu = new JPanel();
        mainPane = new JPanel(new CardLayout());
    }

    private void initComponents() {
        contenedorJuego.setBorder(BorderFactory
            .createTitledBorder(BorderFactory
            .createRaisedBevelBorder(), "ContenedorJuego"));
        mainPane.add(contenedorJuego, "first");

        contenedorMenu.setBorder(BorderFactory
            .createTitledBorder(BorderFactory
            .createRaisedBevelBorder(), "ContenedorMenu"));
        mainPane.add(contenedorMenu, "second");
        add(mainPane, BorderLayout.CENTER);
        add(showC, BorderLayout.SOUTH);
        addC.addActionListener(new ActionListener() {
            private String selectedComponent = "first";
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)mainPane.getLayout();
                if (selectedComponent.equals("first")) {
                    selectedComponent = "second";
                }
                else {
                    selectedComponent = "first";
                }
                cl.show(mainPane, selectedComponent);
           }
       });      
    }

    public static void main(String []args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Interfaz f = new Interfaz();
                f.initComponents();
                f.setLocationRelativeTo(null);
                f.setSize(100, 100);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
}