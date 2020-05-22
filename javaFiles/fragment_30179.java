int counter = 0; // Initiate outside de loop
...
for(int db=0; db<= rowCount; db++) {
    ...
    if (stockPriceDB == popStockValue) {
         ...
         popUpFrame.setLocation(screenSize.width - popUpFrame.getWidth(), 
            screenSize.height - toolHeight.bottom - (popUpFrame.getHeight() * (counter+1)));
         counter++;
    }
}