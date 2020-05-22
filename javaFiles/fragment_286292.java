public static void main(String [] args){
   int numElements;
   if (args.length > 0){
      try{
          numElements = Integer.parseInt(args[0]);
      } catch (NumberFormatException e){
          System.out.println("Argument must be an integer");
          System.exit(1);
      }
   }

   createArray(numElements);
}