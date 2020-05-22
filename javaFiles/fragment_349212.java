static class Customer{
    String name;
    int salary;
    int age;

    public Customer(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}

public static void main(String[] args) {

    ArrayList<Customer> data = new ArrayList<Customer>(){{add(new Customer("x",100,20));add(
    new Customer("y",200,30));add(new Customer("z",300,40));}};
    for(Customer c:data){
        System.out.println(c.name+" _ "+c.salary+" - "+c.age);
    }

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    for(Customer c :data){
        dataset.addValue(c.salary, "low", "");
    }

     //Cont'd other JFreechart codes ...


}