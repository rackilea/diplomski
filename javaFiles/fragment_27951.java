public static void main(String[] args){

    int x = 3;

    String[][] data = new String[x][3]; 

    for(int a = 0; a < x; a++){ 
        data[a] = someFunction();
    }

}

public static String[] someFunction(){
     String[] out = new String[3];
     return out;
 }