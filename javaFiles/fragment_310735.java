public Question(File  newFile) {

    String extension=getExtension(newFile);
    if ( PDFEXTENSION.equalsIgnoreCase(extension)){
        AddJPDFNote(newFile);
    }   else{
       // Utility.DisplayWarningMsg("Only PDF File");
    }
    //it is equal to this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
        }
    });


    this.setMinimumSize(new Dimension(400, 500));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setLayout(new BorderLayout());


    // Name the JMenu & Add Items
    JMenu menu = new JMenu("File");
    menu.add(makeMenuItem("Open"));
    menu.add(makeMenuItem("Save"));
    menu.add(makeMenuItem("Save As"));
    menu.add(makeMenuItem("Close"));
    menu.add(makeMenuItem("Print"));
    menu.add(makeMenuItem("Quit"));


    // Add JMenu bar
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
    setJMenuBar(menuBar);
    setVisible(true);

    // TODO Auto-generated constructor stub
}
public  Question(){
    //super("Question");
    this(new File(""));
}