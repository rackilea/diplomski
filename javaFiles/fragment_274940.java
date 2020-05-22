public static void main(String[] args) throws FileNotFoundException {
   String token1 = "";
   Scanner inFile1 = new Scanner(new File("E:\\text.txt"));

   List<String> temps = new LinkedList<String>();
   inFile1.useDelimiter(". ");

   while (inFile1.hasNext()) {
     token1 = inFile1.nextLine();
     temps.add(token1);
   }
   inFile1.close();

   String[] tempsArray = temps.toArray(new String[0]);
   for (int i = 0; i < tempsArray.length; i++) {
     System.out.println(tempsArray[i]);
   }

   int cnt = 0; //number of words in the string line
   Map<Integer, List<String>> myMap = new HashMap<Integer, List<String>>();
   int[] countArr = new int[tempsArray.length];
   for (int i=0; i<tempsArray.length; i++) {
       int k=0; //number of words that start from the letter "а"
       System.out.println("Line № = " + i);
       StringTokenizer st = new StringTokenizer(tempsArray[i]);           
       while (st.hasMoreTokens()) {
          cnt++;
          String s= st.nextToken();
          if (s.charAt(0)=='a') {                    
             k++;               
          }             
       }
       countArr[i] = k;
       List<String> listOfLines = myMap.get(k);
       if(listOfLines  == null){
          listOfLines = new ArrayList<String>();
          listOfLines.add(tempsArray[i]);
          myMap.put(k, listOfLines);
       } else{
          listOfLines.add(tempsArray[i]);
       }
       System.out.println("Number of words = " + cnt);
       cnt=0;
       System.out.println("Number of words 'а' = " + k);  
    }
    //Call shellsort here on the array of k values
    shellSort(countArr);
    List<String> sortedListOfLines = new ArrayList<String>();
    for(int i=0; i<countArr.length; i++){
       List<String> lineList = myMap.get(countArr[i]);
       if(lineList != null){
          sortedListOfLines.addAll(lineList);
          lineList = null;
          myMap.put(countArr[i], lineList);
       }
    }       
 }