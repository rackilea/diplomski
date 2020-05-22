for (int i = 1; i < amountOfCommands; i++) { // note the < instead of <=
    String key = "K" + i;
    tree.add(key, i);
}
String key = "K" + amountOfCommands;
startTime = System.currentTimeMillis();
tree.add(key, amountOfCommands);
endTime = System.currentTimeMillis();