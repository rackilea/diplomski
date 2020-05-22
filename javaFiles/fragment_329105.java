private void layoutElements() {
    removeAll();
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.anchor = GridBagConstraints.SOUTH;
    add(textField, constraints);

    for (JPanel comp : otherComponents)
        add(comp, new GridBagConstraints());
    if (getParent() != null) {
        getParent().validate();
        getParent().revalidate();
    }
}