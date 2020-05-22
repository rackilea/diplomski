public class JavaApplication6 {
    /**
     * @param i
     * @param j
     */
    public static void paste(int i,int j){
    System.out.println("("+i+","+j+")");
}
    public static void main(String[] args) {
        System.out.println("path taken");
        int[][] F = 
{{0,0,50,150},
{100,200,700,900},
{600,1650,1200,1250},
{1100,1200,1200,1250}};
        int rowLen = 4;
        int columnLen = 4;
int i=rowLen-1;
int j=columnLen-1;
paste(i+1,j+1);
 while(i>0||j>0){
    if(j>0&&F[i-1][j]>F[i][j-1]){
        i--;
        paste(i+1,j+1);
    }
    else if(j>0&&F[i-1][j]<F[i][j-1]){
        j--;
        paste(i+1,j+1);
    }   
    else if(j>0&&F[i-1][j]==F[i][j-1]){
        i--;
        paste(i+1,j+1);  
    } 
    /*new code*/
    else if(j==1||F[i-1][j]<F[rowLen - 1][columnLen - 1]-1){    
        i=i-1;
        F[rowLen - 1][columnLen - 1]--;
        paste(i+1,j+1);

    }
    }}}