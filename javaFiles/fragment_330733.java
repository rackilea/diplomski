findSecondSmallest anArray[]:
    if anArray.length < 2:
        return null;
    fastest = anArray[0];
    secondFastest = anArray[1];
    if fastest > secondFastest:
        fastest = anArray[1];
        secondFastest = anArray[0]
    for each element in anArray:
        if element < fastest:
            secondFastest = fastest;
            fastest = element;
        else if element < secondFastest:
            secondFastest = element;

    return secondFastest