valuesOne = new ArrayList<Integer>();
for (int i = 2; i <= num; i++) {
    if ((num % i == 0)) {               
        valuesOne.add(i);                               
        mapOne.put(num, valuesOne);             
    }
}       
return mapOne;