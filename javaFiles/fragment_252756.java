public static ArrayList<Integer> getStartingWith(int[] numbers, int key)
{
ArrayList<Integer> matching = new ArrayList<Integer>();

String keyAsString = Integer.toString(key);

for(int i = 0; i < numbers.length; i++)
{
    if(Integer.toString(numbers[i]).startsWith(keyAsString))
        matching.add(numbers[i]);
}
return matching;
}