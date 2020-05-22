int c1, c2;
Map<Integer, Integer> sum = new HashMap<>();
while (rstdb.next()) {
    c1 = rstdb.getInt(1); 
    c2 = rstdb.getInt(2);
    if(sum.containsKey(c1)) {
        sum.put(c1, sum.get(c1) + c2);
       //               ^ will return current sum of second column
    } else {
        sum.put(c1, c2);
    }
    rstdb.getInt(1)+"~"+ rstdb.getInt(2)+"~"+sum.get(c1);
}