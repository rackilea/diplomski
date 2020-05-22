public class NewJPanel extends JFrame {
public NewJPanel() {
    this.setSize(400, 300);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    Container container = this.getContentPane();
    JPanel jpPanel = new JPanel ();
    container.add(jpPanel);

    GridBagLayout gridBagLayout = new GridBagLayout();
    jpPanel.setLayout(gridBagLayout);

    JButton btnTestList = new JButton("New button");
    jpPanel.add(btnTestList);

    JList<String> list = new JList<String>();
    GridBagConstraints gbc_list = new GridBagConstraints();
    gbc_list.fill = GridBagConstraints.BOTH;
    gbc_list.gridx = 0;
    gbc_list.gridy = 1;
    jpPanel.add(list, gbc_list);

    btnTestList.addActionListener(new ActionListener () {
        public void actionPerformed(ActionEvent e) {
             String [] testArray = {"a","b","c"};
             list.setListData( testArray);
        }
    });   
}


public static void main(String[] args) {
    NewJPanel jPnl = new NewJPanel ();
    jPnl.setVisible(true);
}
}