List<JTextField> fields = new ArrayList<JTextField> ();
for(int i = 0; i < 30; i++) {
    fields.add(new JTextField(Integer.toString(i)));
}
//...
StringBuilder s = new StringBuilder();
for (JTextField t : fields) {
    s.append(t.getText()).append(" ");
}
//...