public UndecoratedFrameDemo(final String childdir,Ftp_by_apache ftpByApache2)

{

final Ftp_by_apache ftpByApache12=ftpByApache2;

arrayList1=ftpByApache12.getSublFile(childdir);

System.out.println("initial directory: " + childdir);

final JFrame frame = new JFrame("FTP Client By MPST");

frame.setUndecorated(false);

frame.addMouseListener(new MouseAdapter() {

public void mousePressed(MouseEvent e) {

point.x = e.getX();

point.y = e.getY();

}

});

frame.addMouseMotionListener(new MouseMotionAdapter() {

public void mouseDragged(MouseEvent e) {

 Point p = frame.getLocation();

        frame.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);

         }
         });

    frame.setSize(700, 500);
    frame.setLocation(300, 150);
    frame.setLayout(new BorderLayout());

    Image icon = new javax.swing.ImageIcon("ftp-big-icon.jpg").getImage();
    frame.setIconImage(icon);
    Container pane=frame.getContentPane();
    pane.setLayout(new BorderLayout());


    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    menuBar.add(file);

    JMenuItem New = new JMenuItem("New Server");
    New.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*code for new ftp server*/
        }
    });
    file.add(New);

    JMenuItem rename = new JMenuItem("Rename");
    New.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*code for rename*/
        }
    });
    file.add(rename);

    JMenuItem delete = new JMenuItem("Delete");
    New.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*code for delete*/
        }
    });
    file.add(delete);

    JMenuItem connect = new JMenuItem("Connect");
    New.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*code for connect to differnt ftp*/
        }
    });
    file.add(connect);

    JMenuItem item = new JMenuItem("Exit");
    item.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    file.add(item);


    JMenu edit = new JMenu("Edit");
    menuBar.add(edit);

    JMenuItem copy = new JMenuItem("Copy");
    item.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            /* code for copy*/
        }
    });
    edit.add(copy);

    JMenuItem paste = new JMenuItem("Paste");
    item.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            /* code for Paste*/
        }
    });
    edit.add(paste);
    JMenuItem mkdir = new JMenuItem("New Directory");
    New.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    file.add(mkdir);

    popup = new JPopupMenu();
    JMenuItem popupcopy= new JMenuItem("Copy");
    popup.add(popupcopy );
    JMenuItem popuprename= new JMenuItem("Rename");
    popup.add( popuprename );
    JMenuItem popupdelete= new JMenuItem("Delete");
    popup.add( popupdelete );
    JMenuItem menuItem = new JMenuItem("Open");
    menuItem.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){

            Component c = (Component)event.getSource();
            JPopupMenu popup = (JPopupMenu)c.getParent();
            JTable table = (JTable)popup.getInvoker();

            System.out.println(table.getSelectedRow() + " : " + table.getSelectedColumn());
            if(table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()+1).equals("File Folder"))
            {

                System.out.println("File Folder Clicked");


                new UndecoratedFrameDemo(childdir+"/"+table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString(),ftpByApache12);
                // frame.add(table1);
                frame.hide();


            }
            else
            {
                try {


                              ftpByApache12.download(table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString(),"X:/");
            }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    });

    popup.add(menuItem);

    FileTableModel1 fileTableModel1 =new FileTableModel1(arrayList1) ;
    JTable table = new JTable(fileTableModel1)
    {
        public boolean isCellEditable(int data, int column)
        {
            return false;
        }
    };
    table.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            System.out.println("pressed");
        }

        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
                JTable source = (JTable) e.getSource();
                int row = source.rowAtPoint(e.getPoint());
                int column = source.columnAtPoint(e.getPoint());

                if (!source.isRowSelected(row))
                    source.changeSelection(row, column, false, false);

                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    });
    table.setPreferredScrollableViewportSize(table.getPreferredSize());

    JScrollPane scrollPane = new JScrollPane(table);
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

    // JFilePicker filePicker = new JFilePicker("Save file to: ","Browse...");

    // frame.getContentPane().add(filePicker);







    frame.setJMenuBar(menuBar);

    frame.setVisible(true);
}