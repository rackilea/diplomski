public class Test1 {
public static void main(String[] args) {
    int numList[][]=new int[10][10]; 
    int max=0;
    int min=999;
    int minX=0;
    int maxX=0;
    int minY=0;
    int maxY=0;
    for (int row = 0; row < 10; row++) {
        for (int column = 0; column < 10; column++) {
                int num=(int)(Math.random()*100);
                numList[row][column] = num;
                if(num>max){
                    max=num;
                    maxX=row;
                    maxY=column;
                }
                if(num<min){
                    min=num;
                    minX=row;
                    minY=column;
                }
                System.out.print(numList[row][column] + "\t");
         }
                System.out.println("");
    }
    System.out.println("Max value=>"+max+"["+maxX+","+maxY+"]");
    System.out.println("Min value=>"+min+"["+minX+","+minY+"]");
}