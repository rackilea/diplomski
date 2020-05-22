for(x = 0; x < originalString.length(); x++)
{
    char charAt = originalString.charAt(x);
    if(Character.isUpperCase(charAt));
    {
        System.out.print("character [0] located at position [0] is  lowercase");
    }

    if(Character.toUpperCase(originalString.charAt(1)) == originalString.charAt(4));
    {
        System.out.print("character [b] located at position [1] is uppercase"); 
    }

}