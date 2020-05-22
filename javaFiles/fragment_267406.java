public class simple {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n;
        n=3;         
        for(int i=1;i<2*n;i++){
            if(i<=n){
                for(int j=1;j<i;j++){
                    System.out.print(i+"*");
                }
                System.out.println(i);
            }
            else{
                for(int j=i+1;j<2*n;j++){
                    System.out.print(2*n-i+"*");
                }
                System.out.println(2*n-i);
            }
        }
    }
}