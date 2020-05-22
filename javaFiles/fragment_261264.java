public class Sandbox { //opens class

    public static void main(String[] args) {
        ArrayList<Shoe>shoes = new ArrayList<Shoe>();
        shoes.add(new Shoe("Shoe 1", 100)); // the integer represents stock
        shoes.add(new Shoe("Shoe 2", 200));
        shoes.add(new Shoe("Shoe 3", 300));
        Shoe temp;
        String shoeSelected = "Shoe 3"; // you need to use the customer's input here
        int numSeleted = 20; // again, you need this data from the customer input
        for (int i = 0; i < shoes.size(); i++) {
            temp = shoes.get(i);
            if(temp.name == shoeSelected) {
                shoes.get(i).setQuantity(temp.quantity - numSeleted);
                System.out.println(shoes.get(i).name);
                System.out.println(shoes.get(i).quantity);
            }
        }
        System.out.println("wait");
    }

}

class Shoe {
    String name;
    int quantity;

    public Shoe(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}