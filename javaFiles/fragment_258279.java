try{
    fileReader = new FileReader(filePath); //could potentially throw FileNotFoundException
    fileReader = null; //woops
    csvReader = new CSVReader(fileReader); //throws NullPointerException but the compiler will not know this 
    //....other stuff....//
}
catch(Exception e){
    // the compiler told me that a FileNotFoundException can occur so i assume that is the reason the catch has executed
    System.err.println("You have entered an invalid filename");
    //doing anything here that would fix a FileNotFoundException is pointless because that is not the exception that occured
}