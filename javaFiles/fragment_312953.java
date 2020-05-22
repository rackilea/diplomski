class App { // this is the mediator

    // GUI components.
    private JFrame frame;
    private JTextField name;
    private JTextField count;
    private JTextField date;
    // Result is displayed here.
    private JTextArea textArea;

    // Fired by this button.
    private JButton   go;

    private ActionListener actionListener;


    public App(){
        actionListener = new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                okButtonPressed();
            }
        };
    }

    private void okButtonPressed(){
         // template is an object irrelevant to this code.
         template.setData( getData() );
         textArea.setText( template.getTransformedData() );
    }


    public void initialize(){

        frame     = new JFrame("Code challenge v0.1");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        name     = new JTextField();
        count    = new JTextField();
        date     = new JTextField();
        textArea = new JTextArea();
        go       = new JButton("Go");
        go.addActionListener( actionListener ); // prepare the button.

        layoutComponents(); // a lot of panels are created here. Irrelevant.
    }
}