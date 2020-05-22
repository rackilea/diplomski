public class Dish {

    private int catalogNumber;

    private Double costs;

    private String nameofDish;

    public int availabilityOfDish;

    public Dish(int number, Double price, String name, int availability) {
        catalogNumber = number;
        costs = price;
        nameofDish = name;
        availabilityOfDish = availability;
    }

    public int getCatalogNumber() {
        return catalogNumber;
    }

    public Double getCosts() {
        return costs;
    }

    public String getNameofDish() {
        return nameofDish;
    }

    public int getAvailabilityOfDish() {
        return availabilityOfDish;
    }

    @Override
    public String toString() {
        return catalogNumber + " " + costs + " " + nameofDish + " " +   
    availabilityOfDish;
    }
    }