List<String[]> list = //some data
Iterator<String[]> itr = list.iterator();
while (itr.hasNext()){
    String[] array = itr.next(); // You were just missing saving the value for reuse
    System.out.println(array[3] + ":" + array[5]);
}