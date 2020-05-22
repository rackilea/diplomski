...

americano = new JCheckBox("Americano", false);
checkPanel.add(americano);
americano.addActionListener(this);

espresso = new JCheckBox("Espresso", false);
checkPanel.add(espresso);
espresso.addActionListener(this);

doubleEspresso = new JCheckBox("Double Espresso", false);
checkPanel.add(doubleEspresso);
doubleEspresso.addActionListener(this);

latte = new JCheckBox("Latte", false);
checkPanel.add(latte);

boxes = new JCheckBox[] {
    americano, espresso, doubleEspresso, latte
};