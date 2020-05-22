List<JTextField> fields = new ArrayList<JTTextField>();
while( (ln = bufFile.readLine()) != null ) {
    JTextField field = new JTextField(ln);
    inIdPanel.add(field);
    fields.add(field);
}