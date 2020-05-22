// in your constructor:
pizzaBox.addItemListener(new ItemListener() { 
    public void itemStateChanged(ItemEvent e) {
       if (e.getStateChange() == ItemEvent.SELECTED) {
           pizzaNum = pizzaBox.getSelectedIndex(); // in your code you have int pizzaNum but at the same time, pizzaNum is a class variable, probably an error
           // and so on
       } 
    }
});