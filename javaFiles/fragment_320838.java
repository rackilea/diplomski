final static String filename = "filesrc.txt";

public static void main(String[] args) throws IOException {

          Scanner scan = null;
          File f = new File(filename);
          try {
             scan = new Scanner(f);
          } catch (FileNotFoundException e) {
             System.out.println("File not found.");
             System.exit(0);
          }

          int total = 0;
          boolean foundInts = false; //flag to see if there are any integers
             int successful = 0; // I did this to keep track of the number of times
             //a grade is found so I can divide the sum by the number to get the average

          while (scan.hasNextLine()) { //Note change
             String currentLine = scan.nextLine();
             //split into words
             String words[] = currentLine.split(",");

             //For each word in the line
             for(String str : words) {
                 System.out.println(str);
                try {
                    int num = 0;
                    //Checks if a grade is between 0 and 9, inclusive
                    if(str.charAt(1) == '%') {
                        num = Integer.parseInt(str.substring(0,1));
                        successful++;
                        total += num;
                       foundInts = true;
                       System.out.println("Found: " + num);
                    }
                    //Checks if a grade is between 10 and 99, inclusive
                    else if(str.charAt(2) == '%') {
                        num = Integer.parseInt(str.substring(0,2));
                        successful++;
                        total += num;
                       foundInts = true;
                       System.out.println("Found: " + num);
                    }
                    //Checks if a grade is 100 or above, inclusive(obviously not above 999)
                    else if(str.charAt(3) == '%') {
                        num = Integer.parseInt(str.substring(0,3));
                        successful++;
                        total += num;
                       foundInts = true;
                       System.out.println("Found: " + num);
                    }
                }catch(NumberFormatException nfe) { }; //word is not an integer, do nothing
             }
          } //end while 

          if(!foundInts)
             System.out.println("No numbers found.");
          else
             System.out.println("Total: " + total/successful);

          // close the scanner
          scan.close();
       }