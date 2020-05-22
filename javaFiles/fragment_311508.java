//Let say N is 3.. 
public static void main(String[] args){
    factorial(3);                    //(9)
}

public static int factorial (int N)  //(1)N:3, (3)N:2, (5)N:1
{
    if (N<=1 ) 
        return 1;                    //(6)Ret 1, return and continue from whoever called me
    else 
        return (N*factorial (N-1));  //(2), (4), (7)Ret 2*1, (8)Ret 3*2*1
}