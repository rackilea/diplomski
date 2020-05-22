File productData = new File("productData.txt");
Scanner sc = new Scanner(productData);
Integer size = new Integer(sc.nextLine());
Product[] products = new Product[size];
String[] code = new String[size];
int[] price = new int[size];
int countLine = 0;

while (sc.hasNextLine())
{
    int count = 0;
    String line = new String(sc.nextLine());
    for (String retval: line.split("#"))
    {
        if (countLine == 0) {
            code[count] = retval;
        } else if (countLine == 1) {
            price[count] = Double.parseDouble(retval);
        }
        count++;
    }
    countLine++;
}

for (int i = 0; i < size; i++)
{
    products[i] = new Product(code[i], price[i]);
}