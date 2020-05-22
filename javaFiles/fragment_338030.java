String input = scanner.nextLine();

// use regex to split string
String tokens = input.split("\\s+");

String firstPart = tokens[0];

int intPart = 0;
double doublePart = 0;
int transferenciaInt = 0;

if(firstPart.equals("SAQUE") || firstPart.equals("DEPOSITO"))
{
    intPart = Integer.parseInt(tokens[1]);
    doublePart = Double.parseDouble(tokens[2]);
}
else
{
    intPart = Integer.parseInt(tokens[1]);
    transferenciaInt = Integer.parseInt(tokens[2]);
    doublePart = Double.parseDouble(tokens[3]);
}