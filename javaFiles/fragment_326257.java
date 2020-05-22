// The name of the file to open.
static String fileName = "myTextFliel.txt";

public static boolean myHelper(String id, String password) {
    // This will reference one line at a time
    String line = null;
    boolean retVal= false;
    try {
        // FileReader reads text files in the default encoding.
        FileReader fileReader = 
            new FileReader(fileName);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = 
            new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
            //create a token based on 
            String [] token=line.split(";");
            // because you know first and second word of each line in 
            // given file is id and password 
            if (token[0].equals(id) && token[1].equals(password)){
                retVal=true;
                return retVal;
            }
        }   

        // Always close files.
        bufferedReader.close();         
    }
    catch(FileNotFoundException ex) {
        System.out.println(
            "Unable to open file '" + 
            fileName + "'");                
    }
    catch(IOException ex) {
        System.out.println(
            "Error reading file '" 
            + fileName + "'");                  
        // Or we could just do this: 
        // ex.printStackTrace();
    }
    return retVal;
}


public void logging_in(){

    Scanner in = new Scanner(System.in);
    System.out.println("Please enter your login information!");

    String [] log_in_array = new String[2];

    String ID, password;

    System.out.print("ID: ");
    ID = in.next();

    System.out.print("Password: ");
    password = in.next();

    //Stores the ID and PASSWORD to the array. Now we will compare the array to the txt file to find a match
    //Must match FIELD_ONE;FIELD_TWO
    log_in_array [0] = ID;
    log_in_array [1] = password;


    // Here you can call your helper method. 
    boolean foundMe =myHelper(log_in_array [0],log_in_array [1])
    if (foundMe==true){
     //do whatever u want to do
    }

    in.close();

}