public class bmi 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in); // Only need one scanner for multiple variables

        System.out.print("Weight(kg):");
        double weight = input.nextDouble();

        System.out.print("Height (m):");
        double height = input.nextDouble();

        double bodyMassIndex = (weight / (height * height));

        System.out.println(bodyMassIndex);
    }
}