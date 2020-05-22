import java.util.ArrayList;


public class testnCk {

    public static void main(String[] args) {

        ArrayList<int[]> sums = new ArrayList<int[]>();
        int [] t1 = {1,1,0,0};
        int [] t2 = {1,0,0,1};
        int [] t3 = {0,0,0,0};
        int [] t4 = {0,0,1,1};
        ArrayList<int[]> testing = new ArrayList<int[]>();
        testing.add(t1);
        testing.add(t2);
        testing.add(t3);
        testing.add(t4);

        int n = 3;
        int i = -1;
        int[] array = new int[4];
        ArrayList<int[]> whatever = nCk(testing, sums, array, i, n);

        for (int[] test1 : whatever)
        {
            for (int j = 0; j < test1.length; j++) {
                System.out.print(test1[j]);
            }
            System.out.println();
        }
    }
    public static ArrayList<int[]> nCk (ArrayList<int[]> arrayOfDiffPatterns, ArrayList<int[]> solutions, int[] tempsums, int i, int n)
    {
        n--;
        for (int j=i+1; j<arrayOfDiffPatterns.size(); j++){
            int[] array = tempsums.clone();
            for (int k=0; k<arrayOfDiffPatterns.get(0).length; k++){
                    array[k] += arrayOfDiffPatterns.get(j)[k];
            }
            if(n>0){
                nCk(arrayOfDiffPatterns, solutions, array, j, n);
            }
            else{
                solutions.add(array);
            }
        }
        return solutions;
    }
}