List<Integer> received = exchanger.exchange(ints);
System.out.println("Consumer:");
for(Integer x : received) {
    System.out.print(" " + x);
        ...
}