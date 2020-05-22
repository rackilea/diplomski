public Notepad() {
    initComponents();
    setComponents();

    setTitle("Simple Notepad");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setResizable(true);
    setSize(600, 600);
    setJMenuBar(menubar);

    menubar.add(filemenu);
    menubar.add(editmenu);
    menubar.add(formatmenu);
    menubar.add(helpmenu);
    filemenu.add(newmenuitem);
    filemenu.add(openmenuitem);
    filemenu.add(savemenuitem);
    filemenu.add(exitmenuitem);

    //add(area); // remove this, the textarea is already added to the scrollpane
    add(scroll);

    // set the frame visible, only once all components have been added
    setVisible(true);
}

public final void initComponents() {

    area = new JTextArea(); // instantiate the textarea, before adding to the scrollpane
    scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    menubar = new JMenuBar();
    filemenu = new JMenu("    File");
    editmenu = new JMenu("    Edit");
    formatmenu = new JMenu("    Format");
    helpmenu = new JMenu("    Help");
    newmenuitem = new JMenuItem("    New");
    openmenuitem = new JMenuItem("    Open");
    savemenuitem = new JMenuItem("    Save");
    exitmenuitem = new JMenuItem("    Exit");
}