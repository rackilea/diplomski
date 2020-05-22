JButton btnAdd = new JButton("Add");
    btnAdd.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent arg0) {

            //setContentPane(contentPaneClient);
            //panel.setVisible(true);
            //contentPane.setVisible(true);
            //contentPaneClient.setVisible(false);

            LigneJTab l = new LigneJTab(textFieldPrenomClient.getText(),textFieldNomClient.getText(), textFieldAdresseClient.getText(), chckbxHomme.isSelected(), Sport.FOOTBALL);
            myModel.addLine(l);

            panel.setVisible(true);
            contentPane.setVisible(true);
            setContentPane(contentPane);

        }
    });
    btnAdd.setBounds(263, 40, 117, 29);
    contentPaneClient.add(btnAdd);