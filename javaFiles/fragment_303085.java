startTime = System.currentTimeMillis();
for (int i = 1; i <= amountOfCommands; i++) {
    String key = "K" + i;
    tree.add(key, i);
}
endTime = System.currentTimeMillis();