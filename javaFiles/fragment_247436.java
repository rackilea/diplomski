try {

    outFile = new PrintWriter("try.txt");
    outFile.println("First line!");
    outFile.println("Second line!");
    outFile.println("Third line!");

    outFile.close();


 } 
 catch (Exception e) {
    outFile.print("(1) Exception: " + e.getMessage()); // no such element exception
 }

 cat(f1);