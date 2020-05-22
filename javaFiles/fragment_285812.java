import java.util.*;
class Main {

public static int solution(int[] A) {

    int N = A.length;
    int inf=1000000;
    int[] fibs={1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025};
    int[] moves = new int[N+1];
     for(int i=0; i<=N; i++){
        moves[i]=inf;
     }
    for(int i=0; i<fibs.length; i++){
        if(fibs[i]-1<N && A[fibs[i]-1]==1){
            moves[ fibs[i]-1 ] = 1;
        }
        if(fibs[i]-1==N){
           moves[N] = 1;
        }
    }

    for(int i=0; i<N; i++){
        if(A[i]==1)
        for(int j=0; j<fibs.length; j++){
            if(i-fibs[j]>=0 && moves[i-fibs[j]]!=inf && moves[i]>moves[i-fibs[j]]+1){
                moves[i]=moves[i-fibs[j]]+1;
            }                
        }
         System.out.println(i + " => " + moves[i]);
    }

     for(int i=N; i<=N; i++){
        for(int j=0; j<fibs.length; j++){
            if(i-fibs[j]>=0 && moves[i-fibs[j]]!=inf && moves[i]>moves[i-fibs[j]]+1){
                moves[i]=moves[i-fibs[j]]+1;
            }                
        }
         System.out.println(i + " => " + moves[i]);
    }

    if(moves[N]==inf) return -1;
    return moves[N];
}

public static void main(String[] args) {

int[] A = new int[4];

A[0] = 0;
A[1] = 0;
A[2] = 0;
A[3] = 0;
System.out.println(solution(A));
 }
}