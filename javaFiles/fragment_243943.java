String value = String.valueOf((char)key);
if (shift && keyboard.equals("QWERTY"))
{
    switch (value.charAt(0))
    {
        case '1':
            return "!";
        case '2':
            return "@";
        case '3':
            return "#";
    }
}
else if (shift && keyboard.equals("AZERTY"))
{
    switch (value.charAt(0))
    {
        case '&':
            return "1";
        case 'é':
            return "2";
        case '"':
            return "3";
    }
}
else return value;