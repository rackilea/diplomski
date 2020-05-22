for (int i = 0; i < noofgrades; i++) {

    double Grade = 0;
    // monthly interest rate//

    double mograde = readPositiveDouble(input, "Please enter grade " + (i + 1) + ": ", "Errorrrrrrrr");

    if (i == 0) {
        lowestGrade = mograde;
        highestGrade = mograde;
    } else {
        if (mograde < lowestGrade) {
            lowestGrade = mograde;
        }
        if (mograde > highestGrade) {
            highestGrade = mograde;
        }
    }

    sumOfGrade += mograde;
}