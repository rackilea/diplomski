public static void main(String[] args) throws FileNotFoundException {
    // TODO Auto-generated method stub
    if(args.length == 0){
        System.out.println("Please enter a correct text file name!");
        System.exit(1);
    }
    java.io.File file = new java.io.File(args[0]);
    if (file.exists()){
        System.out.println("This file already exists!"); // If file exists, throw exception
        System.exit(1);
    }
    // Create a file    

    java.io.PrintWriter output = new java.io.PrintWriter(file);
}