// original textFieldPanel creational code
JPanel textFieldPanel = new JPanel(new GridBagLayout());
textFieldPanel.add(new JLabel("Name:"), createGbc(0, 0));
textFieldPanel.add(nameField, createGbc(1, 0));
textFieldPanel.add(new JLabel("User Name:"), createGbc(0, 1));
textFieldPanel.add(userNameField, createGbc(1, 1));
textFieldPanel.add(new JLabel("Password:"), createGbc(0, 2));
textFieldPanel.add(passwordField, createGbc(1, 2));

// !! ****** these lines added ******
textFieldPanel.add(new JLabel("Password Hint:"), createGbc(0, 3));
textFieldPanel.add(passwordHint, createGbc(1, 3));