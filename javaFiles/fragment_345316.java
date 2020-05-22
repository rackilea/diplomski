public class Wallet { 

    // The scanner used to read input data.
    private Scanner sc;
    // The maximum load allowed in the wallet.
    private final double MAX_LOAD = 500;
    // The current load in the wallet.
    private double currLoad;
    // The current input from the user.
    private double loadInput;

    /** This is the constructor. **/
    public JavaApplication1() {
        sc = new Scanner(System.in);
        currLoad = 0.0;
        loadInput = 0.0; 
        readInput();
   }

   /** 
    * Reads input from the user.
    *
    */
   public void readInput() {
        System.out.print("Enter Cellphone Number: ");
        cpNumber = sc.nextLine();
        System.out.print("Enter load to be bought: ");
        loadInput = sc.nextDouble();

        // Perform calculation using input.
        currLoad = computeLoad(maxLoad, loadInput);
        System.out.println(loadInput + " was loaded to " + cpNumber);
        System.out.println("Current Load Wallet is now only : " + currLoad);
   }

   /** 
    * Performs computation on the input.
    * @param maxLoad the first value.
    * @param loadInput the second value.
    **/
   private double computeLoad(double maxLoad, double loadInput) {
       return maxLoad - loadInput;
   }

   /** The main thread. Used to create a new instance of JavaApplication1.
    * 
    *  This is so we don't need to litter static all over the place.
    */
   public static void main(String[] args) {
       new Wallet();
   }

}