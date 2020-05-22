private static void printChars(String input, boolean even) {
        int i = 0;
        if(even) { //if we need the even chars, start from 1;
          i=1;
        }
        for(; i < input.length(); i = i + 2){
            System.out.println(input.charAt(i));
        }
}