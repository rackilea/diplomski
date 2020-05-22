public class Main
{
    public static void main(String args[])
    {
        Bread bread = new Bread("Baguette", 150);
        System.out.println("I would like a " + bread.toString());

        Filling filling = new Filling("Prosciutto di Parma", 75);
        System.out.println("with " + filling.toString());

        Sandwich sandwich = new Sandwich(bread, filling);
        System.out.println("Your order is:");
        System.out.println(sandwich.toString());

        int totalCalories = sandwich.getTotalCalories();
        System.out.println("The total calories are " + totalCalories);
    }
}