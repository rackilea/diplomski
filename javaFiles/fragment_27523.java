Double[] sortArrays = {
    (Double) probabilityOfFlush,
    (Double) probabilityOfFullHouse, 
    (Double) probabilityOfOnePair, 
    (Double) probabilityOfPoker, 
    (Double) probabilityOfRoad, 
    (Double) probabilityOfRoyalFlush, 
    (Double) probabilityOfTriple, 
    (Double) probabilityOfTwoPairs
};

Arrays.sort(sortArrays, Collections.reverseOrder());
System.out.println(Arrays.toString(sortArrays));