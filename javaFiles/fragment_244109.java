String line = scanner.nextLine();
   String[] values = line.split(" ");
   int[] intValues = new int[values.length];
   int indx = 0;
   for(String value:values){
     intValues[indx++] = Integer.parseInt(value);
   }