import java.util.ArrayList;
import java.util.List;

public class ExtraTest {
    public static void main(String[] whatsUp) {
        MyData myData = new MyData();

        List<Extra> myExtras = new ArrayList<>();
        myExtras.add(new ExtraInsurance("ReallyBadInsurance"));
        myExtras.add(new ExtraCarCategory(CarCategory.really_big_truck));

        System.out.println("Data before: " + myData);

        myExtras.forEach(extra -> extra.applyExtra(myData));

        System.out.println("Data after: " + myData);
    }

    public static enum CarCategory {not_a_truck, truck, big_truck, really_big_truck}

    public static class MyData {
        String insurance = "none";
        CarCategory carCategory = CarCategory.not_a_truck;

        @Override
        public String toString() {
            return insurance + " : " + carCategory.toString();
        }
    }

    public abstract static class Extra<T> {
        protected final T extraAttributeToProvide;

        public Extra(T extraAttributeToProvide) {
            this.extraAttributeToProvide = extraAttributeToProvide;
        }

        public abstract void applyExtra(MyData myData);
    }

    public static class ExtraInsurance extends Extra<String> {
        public ExtraInsurance(String extraAttributeToProvide) {
            super(extraAttributeToProvide);
        }

        public void applyExtra(MyData myData) {
            myData.insurance = extraAttributeToProvide;
        }
    }

    public static class ExtraCarCategory extends Extra<CarCategory> {

        public ExtraCarCategory(CarCategory extraAttributeToProvide) {
            super(extraAttributeToProvide);
        }

        public void applyExtra(MyData myData) {
            myData.carCategory = extraAttributeToProvide;
        }
    }

}