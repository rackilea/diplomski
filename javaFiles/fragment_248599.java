public class Box {

private static int n; 

public Box(int n){
    this.n = n;
}

public static void doMagic() {
    for (int row = 0; row < n; row++) {
        if(row%2==1)
            System.out.print(" ");
        for (int col = 0; col < n; col++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
   public static void main(String[] args) {
    new Box(4).doMagic();
 } 
}