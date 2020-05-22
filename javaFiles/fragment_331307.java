BufferedReader br = new BufferedReader(new FileReader("proj8.txt"));
    List<Integer> numbers = new ArrayList<Integer>();
    String line = null;

     //String line = br.readLine();

     while ((line = br.readLine()) != null) {
         String []strNumbers = line.split(" ");
         for(String strNumber : strNumbers){
             numbers.add(Integer.parseInt(strNumber));
         }

         //System.out.println(line);            
     }   
     br.close();

     Collections.sort(numbers);
     System.out.println(numbers);