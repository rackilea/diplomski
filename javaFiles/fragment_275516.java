String[][] converted = new String[cost.length][];
for(int index = 0; index < cost.length; index++) {
    converted[index] = new String[cost[index].length];
    for(int subIndex = 0; subIndex < cost[index].length; subIndex++){
        converted[index][subIndex] = Integer.toString(cost[index][subIndex]);
    }
}