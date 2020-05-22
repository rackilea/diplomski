public static void main (String args[]) {  

    for(int row=0;row<10;row++){
        int x;
        x=row;

        for(int col=0;col<10;col++){ 
           StringBuilder mySB = new StringBuilder(x+" ");
           System.out.print(mySB);   
           x = x+10;  
        }

        System.out.println();

    }
}