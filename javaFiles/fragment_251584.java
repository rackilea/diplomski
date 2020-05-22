String number = "1234,56,789";
int count = 0;
for (int i = 0; i < number.length(); i++)
    if (number.charAt(i) == ',')
        count++;
// count holds the number of ',' found