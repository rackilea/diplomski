double num1;
try
{
    num1 = Double.parseDouble(num1Text.getText());
} catch (NumberFormatException e)
{
    // either use a default value or give feedback to the user on what he did wrong
    // for example
    num1 = 1;
}