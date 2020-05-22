public class Test extends JFrame implements ActionListener {
    public Test() {
        Container cp = this.getContentPane();
        JButton b1 = new JButton("add");
        cp.add(b1);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("add")) {
            TestPane frm = new TestPane();
            frm.addActionListener(...); // Add your new action listener here
            cp.add(frm);
        }
    }

    public static void main(String args[]) {
        test t1 = new test();
        t1.show(true);
    } 
}


public class TestPane extends JPanel {
    private JButton b1;
    public TestPane() {
        b1 = new JButton("ok");
        add(b1);
    }

    public void addActionListener(ActionListener listener) {
        b1.addActionListener(listener);
    }

    public void removeActionListener(ActionListener listener) {
        b1.removeActionListener(listener);
    }
}