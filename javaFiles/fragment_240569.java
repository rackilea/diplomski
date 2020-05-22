Long[] firstArray = new Long[10];
Long[] secondArray = new Long[25];

firstArray[0] = new Long("1"); 
firstArray[1] = new Long("2"); 
firstArray[2] = new Long("3"); 

secondArray [0] = new Long("2"); 
secondArray [1] = new Long("3"); 

List<Long> first = new ArrayList<>(Arrays.asList(firstArray));
List<Long> second = Arrays.asList(secondArray);

first.removeAll(second);

Long[] thirdArray = first.toArray(new Long[first.size()]);