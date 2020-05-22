for (i = 0; i < length; i++) {
    for (j = i + 1; j < length; j++) {
        if (countryList[i].compareToIgnoreCase(countryList[j]) > 0) { // >0 instead of <0
            temp = countryList[i];
            countryList[i] = countryList[j];
            countryList[j] = temp;
        }
    }
}