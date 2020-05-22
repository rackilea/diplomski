class MainPanel extends JPanel{

    private JScrollPane scrollPane;
    private JPanel scrollPanel;
    private JButton btnAddPage;
    private static int idx = 0;

    public MainPanel(){
        setPreferredSize(new Dimension(400, 140));
        setLayout(new BorderLayout());
        initComponents();
    }       
    private void initComponents(){
        scrollPanel = new JPanel();
        scrollPanel.setSize(new Dimension(300, 300));       
        scrollPane = new JScrollPane(scrollPanel);  //Let all scrollPanel has scroll bars
        btnAddPage = new JButton("Add New Page");
        btnAddPage.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //for(int x=0; x<10000; x++) //uncomment to test with 10,000 buttons
                addButton(new JButton("Page " + (idx++)));
                scrollPanel.revalidate();
            }
        });             
        add(scrollPane, BorderLayout.CENTER);
        add(btnAddPage, BorderLayout.SOUTH);                
    }

    public void addButton(JButton btn){
        scrollPanel.add(btn);
    }
}