JScrollPane sp = new JScrollPane(comp);
this.add(sp, BorderLayout.CENTER);

private void replace() {
    comp = new Component(...); //name and type of the components is not important
    sp.setViewportView(comp);
}