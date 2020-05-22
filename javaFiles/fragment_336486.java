private Choice buildCommandBox(final Choice custoChoi) {

    custoChoi.addItem("choices");
    custoChoi.addItem("Option1");
    custoChoi.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent ie) {
            System.out.println("the action event for the command" + "box is working.");
            if (custoChoi.getSelectedItem().equals("Option1")) {
                itemDropDown.addItem("things");
                itemDropDown.addItem("stuff");
            }
        }
    });

    return custoChoi;
}