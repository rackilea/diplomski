import Jama.Matrix;

public class Matrixnonsym {
public static void main(String args[]){
     Matrix Mytest=new Matrix(5,5);
     for(int i=0;i<4;i++){
         if(i == 0){
               Mytest.set(i,i,2);
         }
         Mytest.set(i,i,1);
         Mytest.set(i+1,i,1);
      }
    Mytest.print(9,6);
}
}