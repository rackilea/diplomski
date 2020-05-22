public class Test{

    JFrame frame;
    JPanel panel;
    JButton remove,reset;
    JComboBox box;
    final DefaultComboBoxModel items = new DefaultComboBoxModel(new String[]
    {
        "-","Database System","Computer Fundamentals",
        "Computer Maths","Internet Web Tech","Tertiary English 1"                              
    });
    public DefaultComboBoxModel getClone(DefaultComboBoxModel items) {
        DefaultComboBoxModel clone = new DefaultComboBoxModel();
        for(int i = 0;i<items.getSize();i++) {
            clone.addElement(items.getElementAt(i));
        }
        return clone;
    }
    public void display()
    {
        frame = new JFrame();
        panel = new JPanel();

        box = new JComboBox();
        box.setModel(getClone(items));
        remove = new JButton("Remove");
        reset = new JButton("Reset");

        remove.addActionListener((ActionEvent e)->{   
        box.removeItem(box.getSelectedItem());
        });

        reset.addActionListener((ActionEvent e)->{    


        box.setModel(getClone(items));


        });

        panel.revalidate();
        panel.repaint();
        panel.add(box);
        panel.add(remove);
        panel.add(reset);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
    }

    public static void main(String[] args) 
    {
        Test te = new Test();
        te.display();
    }
 }