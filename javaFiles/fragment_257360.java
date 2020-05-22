Random random = new Random();
double timesFirstWasPicked = 0;
double timesSecondWasPicked = 0;
for (int i = 0; i < numberOfPicks; ++i) {
    MySepecialObj chosenValue = pickTheValue(theListOfTwoElements, random);
    if (chosenValue == firstMySepecialObjMock) {
        ++timesFirstWasPicked;
    } else {
        ++timesSecondWasPicked;
    }
}
double probabilityFirst = timesFirstWasPicked / numberOfPicks;
double probabilitySecond = timesSecondWasPicked / numberOfPicks;