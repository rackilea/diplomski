import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        int m, n;
       Scanner s = new Scanner(System.in);
       System.out.println("Enter the no of rows");
        m = s.nextInt();
        System.out.println("Enter the no of columns");
        n = s.nextInt();
       s.close();
        String[][] str = new String[m][n];
        int frontPos = 0;
        int backPos = n-1;

        for (int i=0; i<m; i++){
            int l = Math.round((n)/(i+2));


            if(i==(m-1)){
                frontPos = 0;
                backPos = n-1;
            } else {
            frontPos = l;
            backPos = n-1-l;
            }
            //System.out.println("Difference =="+frontPos);
            boolean contFlag = false;


            do{
                //System.out.println("frontPos=="+frontPos+"|backPos=="+backPos);
                if(frontPos == backPos){
                    str[i][frontPos] = new Integer(i+1).toString();
                } else if(frontPos < backPos){
                    str[i][frontPos] = new Integer(i+1).toString();
                    str[i][backPos] = new Integer(i+1).toString();
                }
                if((backPos-frontPos) > l){

                    contFlag = true;
                    frontPos = frontPos + (l+1);
                    backPos = backPos -(l+1);
                } else {
                    contFlag = false;
                }
            } while(contFlag);


            //System.out.print("\n");
        }

        for(int a=0; a<m; a++){
            for(int b=0; b<n; b++){
                if(str[a][b]==null){
                    System.out.print("*");
                } else {
                System.out.print(str[a][b]);
                }
            }
            System.out.print("\n");
        }
    }
}