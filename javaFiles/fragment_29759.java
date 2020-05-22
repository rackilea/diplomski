public class OpenFile implements ActionListener {

    private YourTableModel model;

    public OpenFile (YourTableModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //...
        model.updateModelWithContent(...); // Or what ever method you provide
    }