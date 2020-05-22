for(String value : values){
   String[] pairs = value.split(" "); 
    int v1 = Integer.parseInt(pairs[0]);
    int v2 = Integer.parseInt(pairs[1]);
    System.out.println("ValueOne - " + v1 + " -- " + "ValueTwo - "+ v2);
}