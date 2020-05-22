public class exam{
    JButton jbtn;

    private void createForm(){
        ...
        jbtn = new JButton("OK");
        jbtn.addActionListener((ActionListener) this);
        ...
    }