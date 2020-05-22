import java.util.ArrayList;
import java.util.List;

public class JavaApplication47
{
    public static void main(String[] args)
    {
        char[] sequence = { '0','1','2'/*,'3','4','5','6','7','8','9',':',';','<','=','>','?','@','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','[',']','^','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' */};

        System.out.print("The combinations are: ");


        // printCombinations(sequence, sequence.length);
        List<String> list = new ArrayList();

        int N=sequence.length;
        char[] data = new char[N];
        for (int r = 0; r <= sequence.length; r++)
        {
            list.addAll(combinations(sequence, data, 0, N - 1, 0, r));
        }


        for (String combo : list)
        {
            System.out.println(combo);
        }
        System.out.println("list size: " + list.size());
    }

    static List<String> combinations(char[] sequence, char[] data, int start, int end, int index, int r) 
    {
        List<String> list = new ArrayList();
        if (index == r) 
        {      
            List<String> tempList = new ArrayList();
            StringBuilder stringbuilder2 = new StringBuilder();

            for (int j = 0; j < r; j++)
            {
                stringbuilder2.append(data[j]).append(" ");
            }

            tempList.add(stringbuilder2.toString());
            return tempList;
        }

        for (int i = start; i <= end && ((end - i + 1) >= (r - index)); i++) 
        {
            data[index] = sequence[i];
            list.addAll(combinations(sequence, data, i + 1, end, index + 1, r));
        }
        return list;

    }

}