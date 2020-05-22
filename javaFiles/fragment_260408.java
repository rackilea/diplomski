import java.util.*;
public class Rand20_200{
   int number20[]=new int[20]; //numbers in random order
   int number200[]=new int[200];

   public Rand20_200(){
    int n=0;
    int ngen[]=new int[20]; //to store which random numbers are generated
    while(n<20){
      int rnd=1 + (getrand100()-1) / 5;
      if (ngen[rnd-1]==0){
        ngen[rnd-1]=1;
        number20[n++]=rnd;
      }
    }
    System.out.println("Random 20 numbers");
    print(number20);

    ngen=new int[200]; //to store which random numbers are generated
    int numoff[]={-1,0}; //offset to add
    n=0;
    while(n<200){
      int rnd=numoff[(getrand100()-1)/50]+ (getrand100()*2);
      if (ngen[rnd-1]==0){
     ngen[rnd-1]=1;
     number200[n++]=rnd;
      }
    }   
    System.out.println("\nRandom 200 numbers");
    print(number200);
   }

   int getrand100(){
    Random rand = new Random();
    return (1+rand.nextInt(100));      
   }

   void print(int arr[]){
     for(int i=0;i<arr.length;i++){
       System.out.print(arr[i]+" ");
     }
   }

   public static void main(String args[]){
     new Rand20_200();
   }

 }