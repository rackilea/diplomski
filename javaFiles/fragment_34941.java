// Declare a public method stringBits that accepts a String str
public String stringBits(String str) 
{
    // Declare a String literal named result containing an empty string ("")
    String result = "";

    // Store the length of the passed String str in integer i
    int i = str.length();

    // Loop while j (loop index) is less than the length of str (j < i)
    // j starts at 0 (int j = 0)
    // Increase j by 2 each iteration (j += 2)
    for(int j = 0; j < i; j += 2)
    {
        // Extract the character between index j and j+1, append to result
        result = result + str.substring(j, j+1);
    }

    // Once the loop has finished, return the result string to the calling method
    return result;
}