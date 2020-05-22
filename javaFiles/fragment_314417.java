package newtable;
    import java.io.*;
    public class Newtable {

    public static void printRow(int[] row) {
         for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

     public static void main(String[] args)throws Exception {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));   
     int twoDm[][]= new int[5][7];
        int i,j,k=1;
        int ans;

        for(i=0;i<5;i++) {
            for(j=0;j<7;j++) {
                twoDm[i][j]=k;
                k++;
            }
        }

        for(int[] row : twoDm) {
            printRow(row);
        }

        //this loop repeats the reserving process (and printing seats) 5 times
        for (int l = 0; l < 5; l++) {
            System.out.print("Enter a Seat number to reserve: ");
            ans = Integer.parseInt(br.readLine());
            k = 1;
            for(i=0;i<5;i++) {
                for(j=0;j<7;j++) {
                    if (k == ans) {
                        //here we check if the seat has already been reserved
                        if (twoDm[i][j]== 0) {
                            System.out.println("That seat has already been reserved");
                        }
                        //if its not reserved then reserve it
                        else {
                             twoDm[i][j]= 0;
                        }
                    }
                    k++;
                }
            }
            //print updated array of seats
            for(int[] row : twoDm) {
                printRow(row);
            }
       }

  }