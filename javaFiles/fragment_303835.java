int counter=-1;
int n=0;
//String[] arr = new String[1000];
List<String> list = new ArrayList<String>(); // Create ArrayList
try{    
    BufferedReader b = new BufferedReader(new FileReader("C:/Users/sky/Documents/NetBeansProjects/Preprocess/src/preprocess/cdr1.txt"));
    String line;
    while ((line = b.readLine()) != null) {
         counter+=1;
         StringTokenizer st2 = new StringTokenizer(line, " ");
         String line5 = (String) st2.nextElement();
         //arr[n] = line5;
         //n++;
         list.add(line5); // Add you string into list
   }
 String[] aa = list.toArray(new String[0]); // convert list into String of array if you need it
}
catch (Exception e){
}