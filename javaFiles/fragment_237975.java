// list containing available locations for the computer to choose
java.util.List<int[]> availableIndexes = new java.util.ArrayList<int[]>();

// go through all our buttons and make a list of ones that are enabled
for(int r=0;r<button.length;r++) {
    for(int c=0;c<button[r].length;c++) {
        if(button[r][c].isEnabled()) {
            availableIndexes.add(new int[]{r, c});
        }
    }
}

// see if we can even do anything
if(availableIndexes.isEmpty()) {
    // cats game, i dont know what you want to do there....
} else {
    // choose one of our avaible buttons at random
    int [] randomButtonIndex = availableIndexes.get((int)(Math.random()*availableIndexes.size()));
    int row = randomButtonIndex[0];
    int column = randomButtonIndex[1];


    // .... continue what you were doing
}