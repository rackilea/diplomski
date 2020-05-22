int jID = lineScanner.nextInt();
int cID = lineScanner.nextInt();
String rego = lineScanner.next();
String date = lineScanner.next();
String day = lineScanner.next();
double fee = lineScanner.nextDouble();

// omitted code
while(lineScanner.hasNextInt())
{
    lineScanner.useDelimiter(",");
    sc[f] = (lineScanner.nextInt());
    f++;
}