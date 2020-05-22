import java.util.*;

public class Test
{
    static AbstractMap.SimpleEntry<Integer, Integer> getMostFrequentN2(ArrayList<Integer> values)
    {
        ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> frequencies = new ArrayList<>();

        int maxIndex = 0;

        main:
        for (int i = 0; i < values.size(); ++i)
        {
            int value = values.get(i);

            for (int j = 0; j < frequencies.size(); ++j)
            {
                if (frequencies.get(j).getKey() == value)
                {
                    frequencies.get(j).setValue(frequencies.get(j).getValue() + 1);

                    if (frequencies.get(maxIndex).getValue() < frequencies.get(j).getValue())
                    {
                        maxIndex = j;
                    }

                    continue main;
                }
            }

            frequencies.add(new AbstractMap.SimpleEntry<Integer, Integer>(value, 1));
        }

        return frequencies.get(maxIndex);
    }

    static AbstractMap.SimpleEntry<Integer, Integer> getMostFrequentNLogN(ArrayList<Integer> values)
    {
        ArrayList<Integer> tmp = new ArrayList(values);

        Collections.sort(tmp);

        AbstractMap.SimpleEntry<Integer, Integer> max = new AbstractMap.SimpleEntry<>(0, 0);

        int current = tmp.get(0);
        int count = 0;
        for (int i = 0; i < tmp.size(); ++i)
        {
            if (tmp.get(i) == current)
            {
                count++;
            }
            else
            {
                if (count > max.getValue())
                {
                    max = new AbstractMap.SimpleEntry<Integer, Integer>(current, count); 
                }

                current = tmp.get(i);

                count = 1;
            }
        }

        if (count > max.getValue())
        {
            max = new AbstractMap.SimpleEntry<Integer, Integer>(current, count); 
        }

        return max;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> numbers = new ArrayList(99);

        for (int i = 0; i < 99; ++i)
        {
            numbers.add((int)(Math.random() * 10));
        }

        System.out.println(numbers);

        System.out.println(getMostFrequentN2(numbers));
        System.out.println(getMostFrequentNLogN(numbers));
    }
}