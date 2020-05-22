Scanner in = new Scanner(new File("src/q22565464/rabbits.dat"));
int numSets = Integer.parseInt(in.nextLine().trim());

for(int curSet = 0; curSet<numSets; curSet++){
   int months = Integer.parseInt(in.nextLine().trim());
   // Could be converted to an array, left for clarity's sake
   long matured = 0;
   long age2 = 0;
   long age1 = 0;
   long age0 = 1;

   for(int i = 0; i < months; i++){
    // the ages of the rabbits increase with each month
       matured += age2;
       age2 = age1;
       age1 = age0;
       age0 = matured;
   }
   System.out.println("Months: " + months + " Population: " + (matured+age2+age1+age0));
}
in.close();