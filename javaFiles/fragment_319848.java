String morse = "";
    for (int j = 0; j < translates.length; j++)
    {
        char a = translates[j];
        if(Character.isLetter(a))
        {
            morse += dottie[a - 'a'];
        }
    }
    return morse;  // this symbol is unknown to the caller