if (amountOfFood > foodMax[j]) {
    System.out.println("Error. Please input a valid amount of food");
    j--;
} else {
    gerbilConsumption[index] = amountOfFood;
}