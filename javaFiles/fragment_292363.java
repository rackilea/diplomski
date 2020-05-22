//the string we use for input
String inputBio;

int optionBox = JOptionPane.showInputDialog(null, heroPane, "Please enter details...", JOptionPane.OK_CANCEL_OPTION);
//now the integer value represents the option selected (OK or CANCEL)
//All we need to do is extract the data and assign it to the string

if (optionBox == JOptionPane.OK_OPTION) {
//the OK option
inputBio = nameOfYourTextField.getText();

} else {
// we have a CANCEL option
}