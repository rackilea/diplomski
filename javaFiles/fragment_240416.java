int sum = 0;
StringBuilder builder = new StringBuilder();
for (int i = 0; i < myString.length(); i++)
{
    char c = myString.charAt(i);
    if(Character.isDigit(c))
    {
        sum += Integer.parseInt(String.valueOf(c));
    } else {
        if (sum != 0) {
            builder.append(sum);
        }
        builder.append(c);
        sum = 0; //reset
    }
}