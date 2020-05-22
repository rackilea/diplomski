class MyFrame extends JFrame {

    PanelB panelB = new PanelB();
    PanelC panelC = new PanelC();

    public MyFrame()
    {
        // ...
        final JTextField panelBtf = panelB.getTextBox();
        final JLabel panelClabel = panelC.getLabel();
        panelBtf.addActionListener(
            new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                panelClabel.setText(panelBtf.getText());
            }}
        );
    }
}