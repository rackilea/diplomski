public static int sumConsonants(char start, char end){
    int sum = 0;
    for(int x=start+1; x<end; x++){
        if(!Character.toString((char)x).matches("[aeiouAeiou]+"))  //if is consonant
            sum += x;                                              //add to sum
    }           
    return sum;
}