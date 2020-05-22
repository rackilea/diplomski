private static final Set<Character> VALID_CHARS = ...;

public boolean isValidPhoneNumber(String number)
{
    for (char c : number,toCharArray())
    {
        if (!VALID_CHARS.contains(c))
        {
           return false;
        }
    }

    // All characters were valid
    return true;
}