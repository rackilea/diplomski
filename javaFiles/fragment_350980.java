import java.util.Scanner;
import java.lang.Thread;
import java.util.Random;
import java.util.ArrayList;

class Hello{  

    public static void main(String[] args){  
        try{
            long count =0;
            ArrayList<A> x = new ArrayList<A>();

         for(;;){
             A a = new A();
             x.add(a);
             count++;

             if(count%100 ==0)
             System.out.println("Created "+ count);

         }
        }
        catch(Exception ex){
            System.out.println("Exception occured");
            System.out.println(ex);
        }
    }
}


class A{
    int a = 10;
    String str = generateRandom();
    String str1 = generateRandom();
    String str2 = generateRandom();
    String str3 = generateRandom();
    String str4 = generateRandom();
    String str5 = generateRandom();
    String str6 = generateRandom();
    String str7 = generateRandom();
    String str8 = generateRandom();
    String str9 = generateRandom();
    String str10 = generateRandom();
    String rst1 = generateRandom();
    String rst2 = generateRandom();
    String rst3 = generateRandom();
    String rst4 = generateRandom();
    String rst5 = generateRandom();
    String rst6 = generateRandom();
    String rst7 = generateRandom();
    String rst8 = generateRandom();
    String rst9 = generateRandom();
    String rst10 = generateRandom();



    private static String generateRandom() {
        String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < 17; i++) {
           int randIndex=rand.nextInt(aToZ.length()); 
           res.append(aToZ.charAt(randIndex));            
        }
        return res.toString();
    }
}