public static void main(String[] args){
    int sizeOfEachJar=10;
    int numberOfJars=2;
    Map<Integer, Integer> jarMap=new HashMap<Integer, Integer>(sizeOfEachJar);
    //I am putting 10 cookies in each jar which is max size of each jar
    for(int i=1;i<=numberOfJars;i++){
    jarMap.put(i, sizeOfEachJar);
    }
    //Now eating three cookies from first jar
    for(int i=0;i<3;i++){
        jarMap.put(1, sizeOfEachJar--); 
    }
    //Now eating 2 cookies out of 2nd jar
    for(int i=0;i<2;i++){
        jarMap.put(2, sizeOfEachJar--); 
    }

    //Now finding out how many cookies remaining in all jars
    int remainingCookies=0;
    for(int i=1;i<=numberOfJars;i++){
        remainingCookies+=jarMap.get(i);
    }
    System.out.println(remainingCookies);
}