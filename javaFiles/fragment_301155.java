public class CommandListener implements ActionListener {
    JButton executeButton;
    JComboBox<String> commandOptionsComboBox;
    JComboBox<String> targetEnvironmentComboBox;

    public CommandListener(JButton executeButton,
                           JComboBox<String> commandOptionsComboBox,
                           JComboBox<String> targetEnvironmentComboBox){
        this.executeButton = executeButton;
        this.commandOptionsComboBox = commandOptionsComboBox;
        this.targetEnvironmentComboBox = targetEnvironmentComboBox;
    }

    /* The rest of your code */
}