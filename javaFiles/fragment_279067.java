public int getPounds() {
    return weightInOunces % 224 / 16;
}

public int getOunces() {
    return weightInOunces % 16;
}

public int getStones() {
    return weightInOunces / 224;
}