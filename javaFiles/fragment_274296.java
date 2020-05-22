int[] dataSet = {30, 45, 60, 65, 72, 78, 85, 87, 95};
int levelR = 0, levelOne = 0, levelTwo = 0, levelThree = 0, levelFour = 0;

for(int mark : dataSet) {
    if(mark >= 80)
        levelFour++;
    else if(mark >= 70 && mark < 80)
        levelThree++;
    else if(mark >= 60 && mark < 70)
        levelTwo++;
    else if(mark >= 50)
        levelOne++;
    else
        levelR++;

}
System.out.println(levelR + ":" + levelOne + ":" + levelTwo + ":" + levelThree + ":" + levelFour);