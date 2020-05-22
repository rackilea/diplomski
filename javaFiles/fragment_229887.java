import java.util.Arrays;
public class Coffee {

    public enum CoffeeTypes {
        COFFEE1("AMERICANO", "LATTE", "CAPPUCCINO"), 
        COFFEE2("ESPRESSO", "RISTRETTO", "AMERICANO");
        String[] elements;
        private CoffeeTypes(String... elements)
        {
            this.elements=elements;
        }
        public String[] getElements()
        {
            return elements;
        }
    }

    public static void main(String[] args) {
        CoffeeTypes myinstance=CoffeeTypes.COFFEE1;
        System.out.println(Arrays.asList(myinstance.getElements()));
    }

}