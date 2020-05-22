import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main
{
    private static String [][] inputList = 
    {
        {"A1","A2","A3","A4"},
        {"B1","B2","B3","B4"},
        {"C1","C2","C3","C4"},
    };
    private static int listSize = 4;
    private static List<List<String>> lists = new ArrayList<List<String>>();

    public static void permutation(List<Integer> indexes, int size)
    {
        if(checkEnd(indexes, size))
        {
            return;
        }
        List<String> nextList = new ArrayList<String>();
        int rowIndex = 0;
        for(int i : indexes)
        {
            nextList.add(inputList[rowIndex++][i]);
        }
        lists.add(nextList);
        permutation(nextIndexes(indexes, size),size);
    }

    public static boolean checkEnd(List<Integer> indexes, int size)
    {
        for(int i : indexes)
        {
            if(i < (size - 1))
            {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> nextIndexes(List<Integer> indexes, int size)
    {
        Collections.reverse(indexes);
        for(int index = 0; index < indexes.size(); index++)
        {
            if(indexes.get(index) < (size - 1))
            {
                indexes.set(index, indexes.get(index) + 1);
                break;
            }
        } 
        Collections.reverse(indexes);
        return indexes;
    }

    public static void printList(List<String> list)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(String field : list)
        {
            builder.append(field);
            builder.append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("}");
        System.out.println(builder.toString());
    }

    public static void main(String[] args)
    {
        List<Integer> indexes = new ArrayList<Integer>();
        for(int i = 0; i < inputList.length; i++)
        {
            indexes.add(0);
        }
        permutation(indexes, listSize);
        for(List<String> list : lists)
        {
            printList(list);
        }
    }
}