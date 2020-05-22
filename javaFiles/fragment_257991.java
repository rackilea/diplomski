double num1 = parseDouble(num1Text.getText());
double num2 = parseDouble(num2Text.getText());

String command = e.getActionCommand();

if (command.equals("Sum"))
{
    ansLabel.setText("" + (num1 + num2));
} else if (command.equals("Subtract"))
{
    ansLabel.setText("" + (num1 - num2));
} else if (command.equals("Multiple"))
{
    ansLabel.setText("" + (num1 * num2));
} else if (command.equals("Divide"))
{
    if (num2 == 0)
    {
        ansLabel.setText("ERROR: Division by zero!");
    } else
    {
        ansLabel.setText("" + (num1 / num2));
    }
}