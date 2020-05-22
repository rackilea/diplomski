for(int i = 0; i < 1000000; i++){
    setUpper(i);
    setLower(i);
    if(!invariantSatisfied()){
        System.out.println("False");
    }
}