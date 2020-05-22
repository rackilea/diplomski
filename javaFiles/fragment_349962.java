int input = 53;
String output = "";
while (input > 0) {
    int num = (input - 1) % 26;
    char letter = (char)(num+65);
    output = letter + output;
    input = (input-1) / 26;
}
System.out.println(output);

BA