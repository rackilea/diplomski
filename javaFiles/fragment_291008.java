public class TestScanner {

        public static void main(String[] args) throws IOException {
            try {   
                Scanner scanner = new Scanner(new File("data.txt"));   
                scanner.useDelimiter(System.getProperty("line.separator"));   
                while (scanner.hasNext())  {  
                    String[] tokens = scanner.next().split("\t");
                    for(String token : tokens) {
                        System.out.print("[" + token + "]");
                    }
                    System.out.print("\n");
                }
                scanner.close();  
            } 
            catch (FileNotFoundException e) {   
                e.printStackTrace();  
            }
       }
    }