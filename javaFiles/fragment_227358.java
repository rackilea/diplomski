public static void main(String[] args) {
   // assuming names is declared and constructed like shown above
   String[] name1 = new String[]{"Amy", "Jose", "Jeremy", "Alice", "Patrick"};
   String[] name2 = new String[]{"Alan", "Amy", "Jeremy", "Helen", "Alexi"};
   String[] name3 = new String[]{"Adel", "Aaron", "Amy", "James", "Alice"};

   addToNames(name1);
   addToNames(name2);
   addToNames(name3);

   // Prove that the set has no duplicates and is ordered:
   for(String name: names)
     System.out.println(name);
}