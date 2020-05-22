static char[] moveWhiteSpaces(char[] input){
    char[] result = new char[input.length];
    int _char = 0, space = input.length-1;
    boolean first_occur = true, first_char = false;
    for(int i = 0; i < input.length; i++){
        char c = input[i]; 
        if(c != ' '){
          result[_char++] = c;
          first_char = true;
        }else if (c == ' ' && first_occur && first_char){
          result[_char++] = c;
          first_occur = false;
        }else{
            result[space--] = c; 
        }
    }
    return result;
}