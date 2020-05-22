$ cat > Merchandise.java
public class Merchandise {

        private String item_name;

        private int item_cost;

        public Merchandise(String name, int cost) {
                this.item_name = name;
                this.item_cost = cost;
        }

        public String getItemName() {
                return item_name;
        }

        public double getItemCost() {
                return item_cost;
        }
}

$ cat > Shopping_Basket.java
import java.util.ArrayList;
import java.util.List;

public class Shopping_Basket {

        private List<Merchandise> basket;

        public List<Merchandise> getList() {
                return basket;
        }

        public Shopping_Basket() {
                basket = new ArrayList<Merchandise>();
        }

        public double getTotalCost() {
                double j = 0;
                for (int i = 0; i < this.getList().size(); i++) {
                        j += basket.get(i).getItemCost();
                }
                return j;
        }

        public static void main(String[] args) {
                Shopping_Basket sb = new Shopping_Basket();
                System.out.println(sb.getTotalCost());

        }

}

$ javac Shopping_Basket.java

$ java Shopping_Basket
0.0