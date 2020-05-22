//BEGIN CHANGE
JPanel llpPanel = new JPanel(new BorderLayout());
JPanel llpbuttonPanel = new JPanel();
llpbuttonPanel.add(online);
llpbuttonPanel.add(offline);
llpbuttonPanel.add(status);
llpbuttonPanel.add(reboot);
llpbuttonPanel.add(account);
llpbuttonPanel.add(amount);
llpbuttonPanel.add(reset);
llpbuttonPanel.add(apprvordecl);
llpPanel.add(llpbuttonPanel, BorderLayout.NORTH);

JPanel textPanel = new JPanel(new BorderLayout());
textPanel.add(logLabel, BorderLayout.NORTH);

JTextArea area = new JTextArea();
textPanel.add(area, BorderLayout.CENTER);
llpPanel.add(textPanel, BorderLayout.CENTER);

//END CHANGE