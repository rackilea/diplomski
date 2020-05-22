Container c = getContentPane();
JTextField[] fields = new JTextField[22];
for (int i = 0; i < 22; i++) {
   fields[i] = new JTextField("Your Value");
   //you can add any listener for JTextField here
   c.add(fields[i]);
}