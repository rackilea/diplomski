String input = "b45z4d";
boolean alpha = false;
boolean numeric = false;
boolean accepted = true;
for (int i = 0; i < input.length(); ++i)
{
    char c = input.charAt(i);
    if (Character.isDigit(c))
    {
        numeric = true;
    } else if (Character.isLetter(c))
    {
        alpha = true;
    } else
    {
        accepted = false;
        break;
    }
}

if (accepted && alpha && numeric)
{
    // Then it is correct
}