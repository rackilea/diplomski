public int getPopulation(String province) {
    for (int i = 0; i < provinces.length; i++) {    // For objects, always use .equals()
        if (province.equals(provinces[i])) { return population[i]; }
    }
    return NO_SUCH_PROVINCE;
}