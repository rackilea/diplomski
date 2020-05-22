public void actionPerformed(ActionEvent event) {
if (event.getSource() == create) {

    String type = classOptions[playerClass.getSelectedIndex()];

    if (type == "Rogue") {
        player1 = new Rogue();
    }
    if (type == "Wizard") {
        player1 = new Wizard();
    }
    if (type == "Warrior") {
        player1 = new Warrior();
    }
    player1.name = name.getText();

    JOptionPane.showMessageDialog(this, "You are a " + type
            + ". Your name is " + player1.name + ".");

    init2();


} else if (event.getSource() == proceed)
{
    JOptionPane.showMessageDialog(this, "It Works!");
    System.out.println("hi");
{

}