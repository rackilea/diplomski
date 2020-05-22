private void MyCode(ProducerTemplate producerTemplate, InputStream content, String endpoint, String fileName, HashMap<String, Object> headers){
    BufferedReader br = new BufferedReader(new InputStreamReader(content));

    ArrayList<String> list = new ArrayList<String>();
    String line;
    int numSplits = 50; 
    int number = 800;          
    int sourcesize=0; 
    try{
        while((line = br.readLine()) != null){
            sourcesize++;
            list.add(line); 
        }
    }
    catch (IOException e){
        e.printStackTrace();
    }
    System.out.println("Lines in the file: " + sourcesize);
    ArrayList<ArrayList<String>> parts = cutListInChunksOfSameSize(list, numSplits);

    for (ArrayList<String> part : parts){
         String  Filename = ""+ (number++);
         System.out.println(Filename);
         StringBuilder builder = new StringBuilder();

         for( int i = 0 ; i <part.size() ;i++){   
             builder.append(part.get(i)).append(System.lineSeparator());                
        }
        producerTemplate.sendBodyAndHeader(endpoint, builder.toString(), "CamelFileName",Filename); 
    }
}

public <T> ArrayList<ArrayList<T>> cutListInChunksOfSameSize(ArrayList<T> list, final int L) {
    ArrayList<ArrayList<T>> parts = new ArrayList<ArrayList<T>>();
    final int N = list.size();
    for (int i = 0; i < N; i += L) {
      parts.add(new ArrayList<T>(list.subList(i, Math.min(N, i + L))));
    }
    return parts;
}