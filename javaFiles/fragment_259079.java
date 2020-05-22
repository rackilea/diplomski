public static void main(String[] args) {

    Random rand = new Random();
    int randomSize = rand.nextInt((13) + 8);

    String password = generatePassword(rand, "", 0, randomSize);
    System.out.println(password);
}


public static char[]chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
    'n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5',
    '6','7','8','9','!','@','$','%','^','&'};

//I think it makes more sense returning the generated string and passing along the random number generator instead of recreating it at each recursive call
public static String generatePassword(Random rand, String password, int position, int size)
{
    boolean isLowerCase = rand.nextBoolean();
    int randomChar = rand.nextInt(chars.length);
    char c = chars[randomChar];
    if(position == size) //base case
        return pasword;
    if(isLowerCase)
    {
        generatePassword(rand, password + chars[randomChar], position + 1, size);
    }
    else //its either upper or lower case
    {
        generatePassword(rand, password + Char.toUpperCase(c), position + 1, size);
    }
}