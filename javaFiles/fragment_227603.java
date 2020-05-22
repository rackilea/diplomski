private static final int ALPHABET_SIZE = 26;

public static void isCountChar(String s)
{
    // Convert input String to char-array (and uppercase to lowercase)
    char[] array = s.toLowerCase().toCharArray();

    // Fill the keys-array with the alphabet
    char[] keys = new char[ALPHABET_SIZE];
    for (int i = 0; i < ALPHABET_SIZE; i++)
    {
        keys[i] = (char)('a' + i);
    }

    // Count how much each char occurs in the input String
    int[] values = new int[ALPHABET_SIZE];
    for (char c : array)
    {
        values[c - 'a']++;
    }

    // Sort both the keys and values so the indexes stay the same
    bubbleSort(keys, values);

    // Print the output:
    for (int j = 0; j < ALPHABET_SIZE; j++)
    {
        if (values[j] != 0)
        {
            System.out.println("character is: " + keys[j] + "; count is: " + values[j]);
        }
    }
}

private static void bubbleSort(char[] keys, int[] values)
{
    // BUBBLESORT (copied from http://www.java-examples.com/java-bubble-sort-example and modified)
    int n = values.length;

    for(int i = 0; i < n; i++){
        for(int j = 1; j < (n - i); j++){        
            if(values[j-1] > values[j]){
                // Swap the elements:
                int tempValue = values[j - 1];
                values[j - 1] = values[j];
                values[j] = tempValue;

                char tempKey = keys[j - 1];
                keys[j - 1] = keys[j];
                keys[j] = tempKey;
            }         
        }
    }
}