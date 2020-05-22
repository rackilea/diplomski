if (num > highestScore) {
    secondScore = highestScore;
    secondName = highestName;

    highestScore = num;
    highestName = name;
} else if (num > secondScore) {
    secondScore = num;
    secondName = name;
}