File file = new File("inventory.txt");
Scanner inputFile = new Scanner(file);

ArrayList<String> productName = new ArrayList<String>();
ArrayList<Double> productQuantity = new ArrayList<Double>();
ArrayList<Double> productPrice = new ArrayList<Double>();

double balance = inputFile.nextDouble();

while (inputFile.hasNext())
{
    String product = inputFile.next();
    try{ 
        double price = inputFile.nextDouble();
    }
    catch(Exception e){
        product = product+" "+inputFile.next();
        double price = inputFile.nextDouble();
    }
    double quantity = inputFile.nextDouble();

    //Takes those variables and stores each of them in ArrayList objects
    productName.add(product);
    productPrice.add(price);
    productQuantity.add(quantity);
}

inputFile.close();