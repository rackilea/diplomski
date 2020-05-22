public class MainClass {   
    public static void main(String[] args) {

    Polynomial poly;
    ArrayList <Polynomial> polyList = new ArrayList<> ();
    String str;


        try {
        File inputFile = new File ("polynomial.txt");
        Scanner scanner = new Scanner (inputFile);
        while (scanner.hasNext()) {
             str = scanner.nextLine();
             poly = new Polynomial(str);
             polyList.add(poly);
        }  
        scanner.close();
        // ################## Print it here ###########  
        // Actual size 
        // ###########################################
        System.out.println(polyList.size()); 


    } catch (FileNotFoundException ex) {
        System.out.println("File not found!!");
      }//end of catch 
   }
}