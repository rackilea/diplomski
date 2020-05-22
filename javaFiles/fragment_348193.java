String[] words = line.split("\t");
int[] numbers = new int[words.length];
for (int i = 0; i < words.length; i++)
{
    numbers[i] = Integer.parseInt(words[i]);
}