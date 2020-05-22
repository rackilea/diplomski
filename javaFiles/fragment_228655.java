double sum = 0;
for (Double value: list) {
    sum += value;
    list1.add(sum);
}
for (Double d : list1) {
    System.out.println(d);    
}