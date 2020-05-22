public class AverageOfGivenNumbers {
    public static int sum(int n1,int n2,int n3,int n4) {
         return n1+n2+n3+n4;
    }
    public static double average(int n1,int n2,int n3,int n4) {
        return sum(n1,n2,n3,n4)/4.0;
    }
    public static void main(String[] args) {
        System.out.println("Average: "+average(4,3,6,1));
    }
}