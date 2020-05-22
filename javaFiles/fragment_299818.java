public class Test {
    public static void main(String[] args){
        for(int interval: new int[]{15,30,60,120}){
            System.out.println((int)(Math.log(interval/15)/Math.log(2)));
        }
    }
}