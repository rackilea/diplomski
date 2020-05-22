public class Elephant {
        private String name ;
    private double weight ;

    // constructor
    public Elephant(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }// end constructor
        // getter method

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    // setter method
    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void Eatting(double kilosOfFood) {
        double consumed = weight + 7.5;
        System.out.println("The eleaphan has eating " + this.weight + "kilograms of food and now weighs " + consumed + "Kg");
    }

        public static void main(String args[]) {
           Elephant e = new Elephant("EE", 10.00);
           e.Eatting(2.5);
        }
    }


    The eleaphan has eating 10.0kilograms of food and now weighs 17.5Kg