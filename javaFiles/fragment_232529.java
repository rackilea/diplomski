public class TestPane extends JPanel {

    private DataModel model;
    private JButton add;

    public TestPane() {
        //...
        add = new JButton("Add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getModel().add();
                int data = getModel().getData();
                // Update the UI in some meaningful way...
            }
        });
        //...
    }

    public void setModel(DataModel model) {
        this.model = model;
    }

    public DataModel getModel() {
        return model;
    }

}