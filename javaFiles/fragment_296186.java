import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboJumbo extends JFrame{

    JLabel label;
    JComboBox combo;

    public static void main(String args[]){
        new ComboJumbo();
    }

    public ComboJumbo(){
        super("Combo Jumbo");
        label = new JLabel("Select a Customer");
        add(label, BorderLayout.NORTH);

        Customer customers[] = new Customer[6];
        customers[0] = new Customer("Frank", 1);
        customers[1] = new Customer("Sue", 6);
        customers[2] = new Customer("Joe", 2);
        customers[3] = new Customer("Fenton", 3);
        customers[4] = new Customer("Bess", 4);
        customers[5] = new Customer("Nancy", 5);

        combo = new JComboBox(customers);
        combo.addItemListener(new ItemListener(){

            public void itemStateChanged(ItemEvent e) {
                Customer c = (Customer)e.getItem();
                label.setText("You selected customer id: " + c.getId());
            }

        });
        JPanel panel = new JPanel();
        panel.add(combo);
        add(panel,BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }


    class Customer{
        private String name;
        private int id;

        public Customer(String name, int id){
            this.name = name;
            this.id = id;
        }

        public String toString(){
            return getName();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
 }