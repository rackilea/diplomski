Integer[] newExchange = new Integer[nColors];
while (true) {
    Integer[] lastExchange = newExchange.clone();
    ...
    exchanges.add(lastExchange);
    output.log.fine("Exchange:" + lastExchange[0] + "," + lastExchange[1]);
}