public class Test {
    public static void main(String[] args) {
        draw(11);
    }

    public static void draw(int n){
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if(i==0 || i==j || i == n-1 || i ==(n-1)/2 || i == n-j-1 || j==0 || j==n-1 || j == (n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();

        }
    }

}