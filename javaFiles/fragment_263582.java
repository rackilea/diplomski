public static void main(String[] args) {
    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            ItemSelectable is = (ItemSelectable)actionEvent.getSource();
            String name=selectedString(is);

            doSomethingWithName(name);
        }
    };

    // Add Actionlistener to ComboBox kundeAuswahl
    kundeAuswahl.addActionListener(actionListener);
}

public static void doSomethingWithName(String name) {
    String test[] = getChildAsArray("kunde","projekt",name);
    // ...
}