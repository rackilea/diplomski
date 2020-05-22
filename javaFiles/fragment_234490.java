@Override
public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == btnAddType) {
        if (panel.getComponentCount() > 0) {
            panel.add(Box.createVerticalStrut(10));
        }
        panel.add(new BoxyTextField(20));
        panel.revalidate();
    }