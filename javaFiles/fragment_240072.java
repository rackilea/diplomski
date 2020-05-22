public class Keypad extends JPanel implements ActionListener {

        private int identifier;
 public Keypad(int identifier) {
                this.identifier = identifier;
               ..............................
               ...............................
                }

          public void actionPerformed(ActionEvent e) {
                switch(identifier)
                {
                case 1:
                String s = CheckStock.stockNo.getText();
                CheckStock.stockNo.setText(s + e.getActionCommand());
                break;
                case 2:
                //for second class
                break;
                case 3:
                // for the third class
                 break;

        }

}