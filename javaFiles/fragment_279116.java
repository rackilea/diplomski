void drawPlot()
{
    String[] dataItemPrices = loadStrings("itemPrices.csv");  //load in .csv file, store as string array
    itemName = new String[dataItemPrices.length-1];
    itemPrice = new float[dataItemPrices.length-1];
    itemPriceScaled = new float[dataItemPrices.length-1]; // <<<<<Added

    for (int i=0; i<dataItemPrices.length-1; i++) 
    {
        //split array to consider commas
        String[] tokensItemPrices = dataItemPrices[i+1].split(",");   
        itemName[i] = tokensItemPrices[0];
        itemPrice[i] = Float.parseFloat(tokensItemPrices[1]);

        dataMin = min(dataMin,itemPrice[i]); 
        dataMax = max(dataMax,itemPrice[i]); 

        itemPriceScaled[i] = map(itemPrice[i], dataMin, dataMax, 
                                        0, (height-100)); //<<<Modified
    }
}