public class Scenario {
    private int number;

    public Scenario() {
        JButton button = new JButton(number + "");
        button.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent arg0) { 
                Scenario.this.number++;
                text.setText(Scenario.this.number + "");
            }
        });
    }
}