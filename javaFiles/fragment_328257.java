public static char flip(char c){
    if(c == '0')
        return '1';
    else 
        return '0';
}

public static void main(String[] args) {
    String start = "0000000000";

    StringBuilder cont = new StringBuilder(start);

    int number = (int)Math.pow(2,10);

    for(int i = 0; i < number; i++)
    {
        if(i != 0){

            int val = (int)Math.floor(i/2);

            for(int j = 0; j <= val; j++){
                // Flip any bit that when modded by 2^j == 0
                if(i % Math.pow(2,j) == 0){

                    cont.setCharAt((cont.length() - (j + 1)), flip(cont.charAt(cont.length() - (j + 1))));
                }
            }
        }   

        System.out.println(cont);

    }   
}