import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [][]table=new int[][]{
            {10,-6,-5,1},
            {0,-1,-7,-3},
            {9,5,-4,7},
            {8,3,-3,7},
            {4,2,-6,9}
        };

        int max;
        int[] t=new int[table[0].length];
        for(int i=0; i<table[0].length; i++){           
            max = table[0][i];
            for(int j=0; j<table.length; j++){
                if(max<table[j][i]){
                    max = table[j][i];                  
                }
            }
            t[i]=max;
        } 

        System.out.println(Arrays.toString(t));
    }
}