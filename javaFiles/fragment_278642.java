public class MyPanel extends javax.swing.JPanel {

    public MyPanel() {
        initComponents();
        //I don't know what you did in initComponents(); so I ve changed the layout to be sure that you didn't use null layout. 
        this.setLayout(new BorderLayout());

        JLabel myLabel = new JLabel();
        myLabel.setText("Hello World");

       //adding the label in MyPanel 
       this.add(myLabel);
    }
}

public class MyFrame extends javax.swing.JFrame {

    MyPanel myPanel = new MyPanel();

    public MyFrame() {
        initComponents();
        // added because of the former reason
        this.setLayout(new BorderLayout());
        this.add(myPanel);
    }
}