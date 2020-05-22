int modeValue=2;
for (total = 2; total < getFrequency.length; total++) {
    if (getFrequency[total] > maxValue) {
        maxValue = (int) getFrequency[total];
        modeValue = total;
    }
    else {

    }
}
System.out.println("Most common value is" + modeValue);