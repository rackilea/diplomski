class abc implements Comparable<abc> {
    String name;
    int id;
    int salary;

    public int compareTo(abc t1){
     return t1.salary - this.salary;
    }
}