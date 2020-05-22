public class SalesRepresentative {

     private String ID;
     private String name;
     private int yearServiced,salary;
     private double salesVolume,commision;


    public SalesRepresentative(String ID, String name, int yearServiced, double salesVolume){
        this.ID = ID;
        this.name = name;
        this.yearServiced = yearServiced;
        this.salesVolume = salesVolume;

        salary();
        commision();
    }

    private void salary(){
        if (yearServiced >=1 && yearServiced <= 5) {
            salary = 1200;
        }
        else if (yearServiced >=6 && yearServiced <= 10 ) {
            salary = 1800;
        }
        else if (yearServiced > 10) {
            salary = 2300;
        }
    }

    private void commision(){
         if (salesVolume >= 1 && salesVolume <= 99.99) {
            commision = salary + (salary * 0.05);
        }
        else if (salesVolume >= 100.00 && salesVolume <= 299.99 ) {
            commision = salary + (salary * 0.10);
        }
        else if (salesVolume >= 300.00) {
            commision = salary + (salary * 0.15);
        }
    }

    public double getCommision()
    {
        return commision;
    }

    public int getSalary()
    {
        return salary;
    }

    public String getID(){
        return ID;
    }

    public String getName(){
        return name;
    }
}