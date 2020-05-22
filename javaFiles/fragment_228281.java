public static void main(String [] args) {
    List<Bean> list = new ArrayList<>();
    list.add(new Bean("John", 10));
    list.add(new Bean("Sam", 666));
    list.add(new Bean("Sam", 9));
    list.add(new Bean("John", 1));
    list.add(new Bean("John", 7));

    Map<String, Integer> sum = list.stream().collect(Collectors.groupingBy(Bean::getName, Collectors.summingInt(Bean::getBalance)));
    sum.entrySet().forEach(x -> list.add(new Bean(x.getKey(),x.getValue(), true)));
    list.sort((x,y) -> {
        int nameComp = x.getName().compareTo(y.getName());
        if (nameComp == 0)
            return x.isSum() ? -1 : 1;
        return nameComp;
    });
    list.forEach(System.out::println);
}

// Bean class with no "bank" variable, but with a new constructor and overloaded .toString()
static class Bean {
    private String name;
    private int balance;
    private final boolean isSum;

    Bean(String name, int balance, boolean isSum) {
        this.isSum = isSum;
        this.name = name;
        this.balance = balance;
    }

    Bean(String name, int balance) {
        this.isSum = false;
        this.name = name;
        this.balance = balance;
    }

    public String getName() { return name; }
    public int getBalance() { return balance; }
    public boolean isSum() { return isSum; }
    @Override
    public String toString() { return name + " | " + balance + (isSum() ? " *Sum*" : ""); }
}