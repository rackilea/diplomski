public class Scratch01 {
public static int fib(int n){           
    if(n <= 1){
            return 1;
        }
        else{
            return fib(n-1) + fib(n-2);
        }
    }

public static void main (String args[]) {
    int[][] tab = new int[10][];
    int count;

    for(int i=0; i<tab.length; i++){
        if(fib(i) % 2 == 0) continue;
        tab[i] = new int[fib(i)];           
    }

    for(int i=0; i<tab.length; i++){
        if(fib(i) % 2 == 0) continue;
        count = tab[i].length;
        for(int j=0; j<tab[i].length; j++){             
            tab[i][j] = count--;
        }
    }

    for(int i=0; i<tab.length; i++){
        if(fib(i) % 2 == 0) continue;
        for(int j=0; j<tab[i].length; j++){
            System.out.print(tab[i][j] + " ");
        }
        System.out.println("");
    }
}