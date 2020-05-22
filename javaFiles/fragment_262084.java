textField = new JTextField();
    ClassB classB = new ClassB(); //INITIALIZING FIRST CLASS
    textField.setText(classB.getDatas());//THERE GETTING THE TEXT AND ADDING TO TEXTFIELD
    textField.setBounds(97, 28, 151, 42);
    contentPane.add(textField);
    textField.setColumns(10);

    JButton btnPrintIt = new JButton("Print it!");
    btnPrintIt.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String text = textField.getText();
            if(!text.equals(null) || text.length() > 0){


                File file = new File("text.txt");                   
                PrintStream printStream;
                try {
                    printStream = new PrintStream(file);
                    printStream.println(text);

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }   

            }
        }
    });