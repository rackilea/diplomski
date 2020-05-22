System.out.printf("%-20s\t%-10s","Username","Password");

for(int x=0; x<=2;x++) {

     System.out.printf("%-20s\t",user[x]);  // Just print user here

     int asterix =password[x].length();
     for (int y=0; y<asterix ;y++){  // For the length of password 
         System.out.print("*");      // Print *
     }
     System.out.println();   // Print newline to move to the next line
}