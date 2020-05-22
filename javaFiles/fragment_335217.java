private JTextArea view;

public SaveQueryListener(JTextArea view, CreateQueryWindow cqw) {
    this.view = view;
    this.setCqw(cqw);
}

@Override
public void actionPerformed(ActionEvent e) {
    String query = view.getText();
    System.out.println("The query is: "+query); //Use this to know what it is returning
    new PostgreSQLJDBC(this.query);
}