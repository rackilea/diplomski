public static void main(String args[]) {
    try {
       List<String> states = new ArrayList(15)<>; // ArrayList is superstructure over array
       FileInputStream fstream = new FileInputStream("C:\\states.search.txt");
       String state; 
       while ((state = br.readLine()) != null) {
           states.add(state);
       }
       in.close();
    } catch (Exception e){
       e.printStackTrace();
    }
  }
 }