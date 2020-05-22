private String[] sequence;
private int index;
private Timer timer;
//...
public Test() {
    //...
    JButton submit = new JButton("Submit");
    submit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            ballR.setForeground(Color.WHITE);
            ballB.setForeground(Color.WHITE);
            ballG.setForeground(Color.WHITE);
            String input = textEntered.getText().toLowerCase();
            String output = translator(input);
            displayT.setText(output);

            timer.stop();

            System.out.println(output);
            List<String> firstPass = new ArrayList<>(Arrays.asList(output.split(" ")));
            List<String> fullPass = new ArrayList<>(25);
            for (String pass : firstPass) {
                if (pass.contains("-")) {
                    String[] parts = pass.split("-");
                    fullPass.addAll(Arrays.asList(parts));
                } else {
                    fullPass.add(pass);
                }
            }

            sequence = fullPass.toArray(new String[fullPass.size()]);
            index = 0;
            timer.start();

        }
    });