public class ComparatorTest {

    public static class Car {
        private String model;
        public Car(String model) {
            this.model = model;
        }
        public String getModel() {
            return model;
        }
    }

    public static void main(String[] args) {
        LinkedList<Car> list = new LinkedList<Car>();
        list.add(new Car("Golf"));
        list.add(new Car("Fiesta"));            
        Collections.sort(list, new Comparator<Car>() {
            public int compare(Car o1, Car o2) {
                String car1Model = o1.getModel();
                String car2Model = o2.getModel();
                // TODO! return a value!
                // Read http://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html#compare(T,%20T) for more information about what to return
            }
        });
    }
}