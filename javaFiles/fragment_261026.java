public final class Order {

    public static int CalculatePrice(String size, boolean meat, boolean cheese, boolean veggies){
        int price = 0;

        if (size.equals("Small")){
            price += 9;
        }
        else if (size.equals("Medium")){
            price += 10;
        }
        else if (size.equals("Large")){
            price += 11;
        }
        if (meat == true){
            price += 2;
        }
        if (cheese == true){
            price += 2;
        }
        if (veggies == true){
            price += 2;
        }

        return price;
    }

}