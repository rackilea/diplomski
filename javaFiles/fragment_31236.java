public class NewClass {
    private NewJFrame frame = null;

    public NewClass(NewJFrame frame) {
        this.frame = frame;
    }

    public String call()
    {

        String text;
        text = frame.TextBox1.getText();
        frame.TextBox1.setText(text + "1");  //This will work now.
        JOptionPane.showConfirmDialog(null,text,"22222222",JOptionPane.PLAIN_MESSAGE);
        return text;
    }

}