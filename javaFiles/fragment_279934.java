LoginForm.api.selectVirtualServer(server);
    for( final PrivilegeKey tokens  : LoginForm.api.getPrivilegeKeys()) {

        final JLabel label =  new JLabel(tokens.getToken() + "   " + tokens.getGroupId() + "   " +  "\n");

        panel.add(label);
        JButton button = new JButton("Löschen");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginForm.api.deletePrivilegeKey(tokens.getToken());
                panel.remove(label);
                panel.repaint();
            }
        });
        button.setVisible(true);
        button.setPreferredSize(new Dimension(87,25));
        panel.add(button);

    }
    JScrollPane scrollPane = new JScrollPane (panel,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    add(scrollPane);

    LoginForm.api.selectVirtualServerById(LoginForm.vServerId);
}