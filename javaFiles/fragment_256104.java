public class Tester
{
    public static void main(String[] args)
    {
        // Create a new Checkup object
        Checkup personA = new Checkup(1, 2, 3, 4.0, 5.0);

        // Calculate ratio
        personA.setComputeRatio(personA.getLDL(), personA.getHDL()); // <== This is needed...

        // Get results
        personA.printCheckup(); // ... before you do this. Otherwise results will always equal 0.0
    }
}