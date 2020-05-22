public int setPounds(int pounds) {
    int stones = getStones();
    weightInOunces = stones * 244 + getOunces() + pounds * 16;
}

public int setOunces(int ounces) {
    int pounds = getPounds();
    weightInOunces = pounds * 16 + ounces;
}

public int setStones(int stones) {
    weightInOunces = stones * 244 + weightInOunces % 244;
}