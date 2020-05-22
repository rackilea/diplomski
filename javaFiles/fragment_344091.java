public class Employee {

    private int sales;
    private String name;

    public Employee(String name, int sales){
        this.name = name;
        this.sales = sales;
    }
    public String getName(){
        return this.name;
    }
    public int getSales(){
        return this.sales;
    }
}