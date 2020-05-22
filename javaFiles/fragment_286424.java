// It's not clear where newExchange is actually populated
Integer[] newExchange = new Integer[nColors];
while (true) {
    Integer[] lastExchange = new Integer[nColors];
    ...
    for (int i=0; i<nColors; i++) {
       lastExchange[i] = newExchange[i];
    }
    ...
    exchanges.add(lastExchange);
    output.log.fine("Exchange:" + lastExchange[0] + "," + lastExchange[1]);
}