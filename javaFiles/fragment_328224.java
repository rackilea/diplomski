public class SomePanel extends JPanel{

private JButton button = new JButton("Open New Frame");
private int value;


public SomePanel(){

    // initialization code ... size, color ...

    button.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
              setValue(1);
        }

    });    
}

public void setValue(int value) {
    int oldValue= this.value;
    this.value = value;
    firePropertyChangeValue("value",oldValue,this.value);
}

}