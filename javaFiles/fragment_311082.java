Integer[] lastExchange = getValue();
Integer[] exchangeToAdd = getValue();
exchanges.add(exchangeToAdd);

while (true) {
   Integer[] newExchange = getValue(lastExchange);
   Integer[] exchangeToAddForLoop = new Integer[nColors];
   for (int i=0; i<nColors; i++) {
      lastExchange[i] = newExchange[i];
      exchangeToAddForLoop[i] = newExchange[i];
   }
   exchanges.add(exchangeToAddForLoop);
}