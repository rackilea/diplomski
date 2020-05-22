List<Integer> numList = new ArrayList<Integer>();
while(true) {
   System.out.println("Enter a positive integer value (or -1 to stop): ");
   String line = in.nextLine();
   if(line.length() <1){
      break;
   }
   String [] numbers = line.split(" ");
   for(String num: numbers){
          numList.add(Integer.parseInt(num));
   }
 }
 in.close();

 Integer[] numArray = numList.toArray(new Integer[numList.size()]);