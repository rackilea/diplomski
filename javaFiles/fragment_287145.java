//Card.java
//this is the basic card class the extends JPanel
//it contains the name so you can easily switch to it
public class Card extends JPanel{
    public final String name;

    public Card(String name){
        this.name = name;
    }
}

//SimpleLabelCard.java
//extends Card, so it is also a JPanel
public class SimpleLabelCard extends Card{

    private JLabel label = new JLabel();

    public SimpleLabelCard(String name, String text) {
        super(name);
        label.setText(text);
        add(label);
    }
}

//SimpleTextAreaCard.java
public class SimpleTextAreaCard extends Card{

    private JTextArea text = new JTextArea();

    public SimpleTextAreaCard(String name, String text) {
        super(name);
        this.text.setText(text);
        setLayout(new BorderLayout());
        add(this.text, BorderLayout.CENTER);
    }
}