int storeFirstNum = 0;
int storeSecondNum = 0;
int storeThirdNum = 0;
int storeFourthNum = 0;

// secondPlace start
if (firstNum != firstPlace && firstNum != fourthPlace) {
    storeFirstNum = firstNum;
}
if (secondNum != firstPlace && secondNum != fourthPlace) {
    storeSecondNum = secondNum;
}
if (thirdNum != firstPlace && thirdNum != fourthPlace) {
    storeThirdNum = thirdNum;
}
if (fourthNum != firstPlace && fourthNum != fourthPlace) {
    storeFourthNum = fourthNum;
}
if (storeFirstNum > storeSecondNum && storeFirstNum > storeThirdNum
        && storeFirstNum > storeFourthNum) {
    secondPlace = storeFirstNum;
} else if (storeSecondNum > storeFirstNum
        && storeSecondNum > storeThirdNum
        && storeSecondNum > storeFourthNum) {
    secondPlace = storeSecondNum;
} else if (storeThirdNum > storeFirstNum
        && storeThirdNum > storeSecondNum
        && storeThirdNum > storeFourthNum) {
    secondPlace = storeThirdNum;
} else if (storeFourthNum > storeFirstNum
        && storeFourthNum > storeSecondNum
        && storeFourthNum > storeThirdNum) {
    secondPlace = storeFourthNum;
}
// secondPlace end