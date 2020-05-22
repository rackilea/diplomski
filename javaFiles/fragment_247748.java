public String showPrompt(JComponent owner) {
    JDialog pwindow = new JDialog(SwingUtilities.windowForComponent(owner), title, Dialog.ModalityType.APPLICATION_MODAL);

    JPanel main = new JPanel();
    main.setLayout(new GridLayout(2, 1));

    JPanel buttons = new JPanel();
    buttons.setLayout(new FlowLayout(FlowLayout.CENTER));

    JPanel input = new JPanel();
    input.setLayout(new FlowLayout(FlowLayout.CENTER));
    input.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel prompt = new JLabel(promptstr);
    input.add(prompt);

    JTextField in = new JTextField(25);
    input.add(in);

    JButton ok = new JButton("OK");
    buttons.add(ok);
    ok.addActionListener((ActionEvent e) -> {
        myInput = in.getText();
        try (FileWriter output = new FileWriter(new File("C:\\Users\\Mike\\Desktop\\output.txt"))) {
            //function here
        } catch (IOException ex) {
        }
        pwindow.dispose();
    });

    JButton cancel = new JButton("Cancel");
    buttons.add(cancel);
    cancel.addActionListener((ActionEvent e) -> {
        try (FileWriter output = new FileWriter(new File("C:\\Users\\Mike\\Desktop\\output.txt"))) {
            //function here
        } catch (IOException ex) {
        }
        pwindow.dispose();
    });

    main.add(input);
    main.add(buttons);

    pwindow.getContentPane();
    pwindow.add(main);
    pwindow.pack();
    pwindow.setVisible(true);

    return myInput;
}