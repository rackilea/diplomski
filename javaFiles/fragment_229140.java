class Tree<T> {

    private final Comparator<T> comparator;


    public Tree(final Comparator<T> comparator) {
        this.comparator = comparator;
    }
}

class Car {
    private String model;
    private String VIN;
    private String licencePlate;


    public String getModel() {
        return this.model;
    }


    public String getVIN() {
        return this.VIN;
    }


    public String getLicencePlate() {
        return this.licencePlate;
    }

}


public static void main(final String[] args) {

    Comparator<Car> comp1 = new Comparator<Car>() {

        @Override
        public int compare(final Car car1, final Car car2) {
            return car1.getVIN().compareTo(car2.getVIN());
        }
    };

    Comparator<Car> comp2 = new Comparator<Car>() {

        @Override
        public int compare(final Car car1, final Car car2) {
            return car1.getLicencePlate().compareTo(car2.getLicencePlate());
        }
    };

    Tree<Car> tree1 = new Tree<Car>(comp1); //this tree will keep order according to car's VIN
    Tree<Car> tree2 = new Tree<Car>(comp2); // this tree will keep order according to car's licence plate


}