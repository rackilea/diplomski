String[] itemNames = new String[100];
int[] numbersSold = new int[100];
double[] costs = new double[100];
int curIndx = 0;

for (String itemName = file.readLine(); itemName != null; itemName = file.readLine()) {
    // add item name
    itemNames[curIndx] = itemName;

    //print file in columns
    numberSoldParse = file.readLine();
    numberSold = Integer.parseInt(numberSoldParse);

    // add number sold
    numbersSold[curIndx] = numberSold;

    costParse = file.readLine();
    cost = Double.parseDouble(costParse);

    // add cost
    costs[curIndx] = cost;

    // increment indx pointer 
    curIndx++;
}