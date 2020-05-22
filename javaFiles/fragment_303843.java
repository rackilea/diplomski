int capitalletters = 0;
int lowerletters = 0;
int vowel = 0;

for(int i=0;i<characters;i++) {
    char charToAnalyse = input.charAt(i);

    if (Character.isUpperCase( charToAnalyse )) { 
        capitalletters++; 
    }
    else if (Character.isLowerCase( charToAnalyse  )){ 
        lowerletters++; 
    }
    //Imagine if there were many if statement and the condition 
    //was already true in the first...

    //count vowels;
    switch( charToAnalyse  ) {
        case 'a':
        case 'e':
        case 'ı':    
        case 'i':
        case 'o':
        case 'ö':
        case 'u':
        case 'ü':
            vowel++;
        break; //You can omit this one if it is at the end;
    }

}