import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author JFVARUGH
 * here is my String. [NOT A Arraylist] [1],
 *  [1],
 *  [<2254,89014103211118510720,C,D>,<2254,89014103211118510720,C,D>,<2254,89014103211118510720,C,D>], ...
 *
 *item 01 : [1]
  item 02 : [<2254,89014103211118510720,C,D>,<2254,89014103211118510720,C,D>,<2254,89014103211118510720,C,D>,<2254,89014103211118510720,C,D>]
  item 03 : [22630]
 */
public class StringProblel {

    @SuppressWarnings("null")
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int index =0, tempIndex=0,stringIndex=0;
        char[] keyWrds =  {'[',']',','};
        char[][] temp = new char[1000][1000];

        String sourceStr = "[1],[<2254,89014103211118510720,C,D>,<2254,89014103211118510720,C,D>,<2254,89014103211118510720,C,D>,<2254,89014103211118510720,C,D>], [22630] ";

        while(index < sourceStr.length()){
            if( sourceStr.charAt(index) == keyWrds[0] ){
                temp[stringIndex][tempIndex] = sourceStr.charAt(index);
                while(sourceStr.charAt(index) != keyWrds[1] && index < sourceStr.length()){
                    index++;
                    temp[stringIndex][++tempIndex] = sourceStr.charAt(index);                   
                }

                stringIndex++;              
            }
            index++;
        }
        System.out.println(temp[1]);
    }

}


The time complexity will be O(n2). There is scope for improvements !