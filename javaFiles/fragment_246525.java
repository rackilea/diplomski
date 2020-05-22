public static void main(String args[]){
    String[] array = {"Apple","Banana","Apple","Peanut","Banana","Orange","Apple","Peanut"};
    Map<String, Integer> result = new HashMap<>();
    for(String s : array){

        if(result.containsKey(s)){
            //if the map contain this key then just increment your count
            result.put(s, result.get(s)+1);
        }else{
            //else just create a new node with 1
            result.put(s, 1);
        }
    }
    System.out.println(result);
}