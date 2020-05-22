public class PetsMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // We declare variables here
        String name;
        int age;
        double weight;
        Pets pet = new Pets(); // Initialize Object
        ArrayList<Pets> pets = new ArrayList<Pets>(); // We create the ArrayList


        Scanner keyboard = new Scanner(System.in) ;
        System.out.println("Please enter the number of pets") ;
        int numberOfPets = keyboard.nextInt() ;

        String fileName = "pets.txt" ; 
        FileInputStream fileStream = null ;

        String workingDirectory = System.getProperty("user.dir") ;
        System.out.println("Working Directory for this program: " + workingDirectory) ;

        try
        {
            String absolutePath = workingDirectory + "\\" + fileName ;
            System.out.println("Trying to open: " + absolutePath) ;
            fileStream = new FileInputStream(absolutePath) ;
            System.out.println("Opened the file ok.\n") ;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File \'" + fileName + "\' is missing") ;
            System.out.println("Exiting program. ") ;
            System.exit(0) ;
        }

        Scanner fileScanner = new Scanner(fileStream) ;
        int sumAge = 0 ;
        double sumWeight = 0 ;

        String petName = "Pet Name" ;
        String dogAge = "Age" ;
        String dogWeight = "Weight" ;
        String line = "--------------" ;
        System.out.printf("%11s %15s %19s %n", petName, dogAge, dogWeight) ;
        System.out.printf("%s %17s %17s %n", line, line, line) ;
        for (int counter = 0; counter < numberOfPets; counter++) 
        {
            fileScanner.useDelimiter(",") ;                
            name = fileScanner.next() ;
            fileScanner.useDelimiter(",") ;
            age = fileScanner.nextInt() ;
            fileScanner.useDelimiter("[,\\s]") ;
            weight = fileScanner.nextDouble() ;
            sumAge += age ; 
            sumWeight += weight ;
            System.out.printf("%-15s %15d %18s %n", name, age, weight) ; 

            // **We add the pet to the collection
            pets.add(new Pets(name,age,weight)); // Adding it to the ArrayList
        }

        // Then we acces to the ArrayList and we print what we want.
        for(int x=0; x < pets.size(); x++){
            System.out.print(pets.get(x).toString());
        }

        System.out.println("\nThe total weight is " + sumWeight) ;
        System.out.println("\nThe total age is " + sumAge) ;

        try
        {
            fileStream.close() ;
        }
        catch (IOException e)
        {
            // don't do anything
        }
    }

}