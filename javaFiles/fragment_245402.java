public void fillGaps() {       
    tempGaps = new int[difference];
    finalTemps = new int[difference];
    for (int i = 0; i < difference; i++) { //navigate through every temperature
        tempGaps[i] = temp[0] + i; //assign the current temperature
        Integer frequency = map.get(new Integer(tempGaps[i])); //fetch the frequency
        finalTemps[i] = frequency == null ? 0 : frequency; //assign 0 if null, otherwise frequency if not null
    }
}