double avg = (double)ListUtil.sum(list)/list.size();
double editedAvg = avg;
k = 10;
while (avg <= k - 0.5) {
    avg = (double) avg + ((k - avg)/(double)(list.size() + 1));
    if(avg <= k - 0.5) {
        editedAvg = avg;
        list.add(k);
        System.out.println(editedAvg);
    }
}
System.out.println("Final avg: " + editedAvg);