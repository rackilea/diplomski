tnPreviewPage = new JButton("Preview Single");
    btnPreviewPage.setFocusable(false);
    btnPreviewPage.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {

//Add YourJTextField.requestFocusInWindow() here, but not sure if the other information is needed
txtStartPosition.setCaretPosition(txtStartPosition.getCaretPosition() - 1);
            new UIPreviewPage().execute();
        }
    });
    panel.add(btnPreviewPage, "cell 1 18,alignx right");