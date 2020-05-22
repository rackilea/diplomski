JPanel loginUNPanel = new JPanel(new GridLayout(3,2));

  loginUNPanel.add(loginUsername);
  loginUNPanel.add(loginUNTextField);

  loginUNPanel.add(loginPassword);  // ***** adding it once ***** 
  loginUNPanel.add(loginPTextField);

  loginUNPanel.add(new JLabel(""));  
  loginUNPanel.add(login);

  JPanel registerUNPanel = new JPanel(new GridLayout(4,2));

  registerUNPanel.add(registerUsername);
  registerUNPanel.add(registerUNTextField);

  registerUNPanel.add(registerPassword);
  registerUNPanel.add(registerPTextField);

  registerUNPanel.add(registerEmail);
  registerUNPanel.add(registerETextField);

  registerUNPanel.add(new JLabel(""));
  registerUNPanel.add(register);

  loginUNPanel.add(loginPassword);  // ***** adding it again. ***** 

  JPanel main = new JPanel(new GridLayout(1,2));