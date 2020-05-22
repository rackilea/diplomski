JTextField[] fields = new JTextField[SIZE];
for (int i = 0; i < fields.length; i++) {
   fields[i] = new JTextField("Field " + i);
   fields[i].addActionListener(myActionListener);
   c.add(fields[i]);
}