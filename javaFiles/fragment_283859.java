public class FileInfo extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String TITLE   = "FileInfo" ;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                FileInfo    app = new FileInfo() ;
                app.setVisible(true) ;
            }
        }) ;
    }

    private JTextField  nameField ;
    private JTextField  propertiesField ;

    private FileInfo() {
        super(TITLE) ;
        Container   contentPane = getContentPane() ;
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS)) ;

        // Setup button
        contentPane.add(new JButton(new AbstractAction("Get file info") {
            private static final long serialVersionUID = 1L;
            public void actionPerformed(ActionEvent event) { performAction() ; }
        })) ;

        // setup filename
        JPanel  panel   = new JPanel(new BorderLayout()) ;
        panel.add(new JLabel("Filename: "), BorderLayout.WEST) ;
        nameField   = new JTextField(15) ;
        nameField.setEditable(false) ;
        panel.add(nameField, BorderLayout.CENTER) ;
        contentPane.add(panel) ;

        // setup properties
        panel   = new JPanel(new BorderLayout()) ;
        panel.add(new JLabel("Properties: "), BorderLayout.WEST) ;
        propertiesField = new JTextField(35) ;
        propertiesField.setEditable(false) ;
        panel.add(propertiesField, BorderLayout.CENTER) ;
        contentPane.add(panel) ;

        // Position and resize main window
        pack() ;
        Dimension   size    = getSize() ;
        Toolkit toolkit = Toolkit.getDefaultToolkit() ;
        Dimension   screen  = toolkit.getScreenSize() ;
        int x   = (screen.width / 2) - (size.width / 2) ;
        int y   = (screen.height / 2) - (size.height / 2) ;
        setLocation(x, y) ;
    }

    private void performAction() {
        JFileChooser    chooser = new JFileChooser() ;
        chooser.setVisible(true) ;
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File    file    = chooser.getSelectedFile() ;
            nameField.setText(file.getName()) ;
            StringBuffer    buffer  = new StringBuffer(128) ;
            if (file.canExecute())  buffer.append("[Execute]") ;
            if (file.canRead())     buffer.append("[Read]") ;
            if (file.canWrite())    buffer.append("[Write]") ;
            buffer.append("[Size:").append(Long.toString(file.length())).append("]") ;
            propertiesField.setText(buffer.toString()) ;
        }
    }
}