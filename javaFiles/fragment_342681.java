String result = entry;
    //              ^^^^^

    for(int x = 0; x < (morseCharacter.length); x++)
    {
        result = result.replaceAll(characters[x], morseCharacter[x]);
    } //         ^^^^^^