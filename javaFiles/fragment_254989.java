public class Pizza extends JFrame {

    public Pizza() {
        :
        pizzaBox.addItemListener(new ItemListener() { 
            public void itemStateChanged(ItemEvent e) {
                 pizzaBox_itemStateChanged(e);
            }
        });
        :
    }

    private void pizzaBox_itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
           pizzaNum = pizzaBox.getSelectedIndex();
           // and so on
        }
    }

    :
}