int rollsInARow = 0; // store how many times we roll the value
int totalThrows = 0;

while(rollsInARow != rollLength) {
    int roll = randomNumber.nextInt(nSides)+1;
    if(roll == value) {
        rollsInARow++; // Count consecutive rolls that are the wanted value
    } else {
        rollsInARow = 0; // Reset if we get a roll other than value 
    }
    totalThrows++; // +1 after each roll
}