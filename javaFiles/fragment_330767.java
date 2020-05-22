public class ComponentWrapper extends JComponent{

    private JComboBox combo;
    private JTextArea textArea;

    public ComponentWrapper(){
        combo = new JComboBox();
        textArea = new JTextArea();
        add(combo);
        add(textArea);
    }

    public Text getTextArea(){
        return textArea;
    }

    public JComboBox getComboBox(){
        return comboBox;
    }
}