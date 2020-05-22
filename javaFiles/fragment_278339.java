/**
 * Parses a string that represents an amount of money.
 * @param s A string to be parsed
 * @return A currency value containing the currency,
 * integer part, and decimal part.
 */
public static CurrencyValue parseCurrency(String s){
    if(s==null || s.length()==0)
        throw new NumberFormatException("String is null or empty");
    int i=0;
    int currencyLength=0;
    String currency="";
    String decimalPart="";
    String integerPart="";
    while(i<s.length()){
        char c=s.charAt(i);
        if(Character.isWhitespace(c) || (c>='0' && c<='9'))
            break;
        currencyLength++;
        i++;
    }
    if(currencyLength>0){
        currency=s.substring(0,currencyLength);
    }
    // Skip whitespace
    while(i<s.length()){
        char c=s.charAt(i);
        if(!Character.isWhitespace(c))
            break;
        i++;
    }
    // Parse number
    int numberStart=i;
    int numberLength=0;
    int digits=0;
    //char lastSep=' ';
    while(i<s.length()){
        char c=s.charAt(i);
        if(!((c>='0' && c<='9') || c=='.' || c==','))
            break;
        numberLength++;
        if((c>='0' && c<='9'))
            digits++;
        i++;
    }
    if(digits==0)
        throw new NumberFormatException("No number");
    // Get the decimal part, up to 2 digits
    for(int j=numberLength-1;j>=numberLength-3 && j>=0;j--){
        char c=s.charAt(numberStart+j);
        if(c=='.' || c==','){
            //lastSep=c;
            int nsIndex=numberStart+j+1;
            int nsLength=numberLength-1-j;
            decimalPart=s.substring(nsIndex,nsIndex+nsLength);
            numberLength=j;
            break;
        }
    }
    // Get the integer part
    StringBuilder sb=new StringBuilder();
    for(int j=0;j<numberLength;j++){
        char c=s.charAt(numberStart+j);
        if((c>='0' && c<='9'))
            sb.append(c);
    }
    integerPart=sb.toString();
    if(currencyLength==0){
        // Skip whitespace
        while(i<s.length()){
            char c=s.charAt(i);
            if(!Character.isWhitespace(c))
                break;
            i++;
        }
        int currencyStart=i;
        // Read currency
        while(i<s.length()){
            char c=s.charAt(i);
            if(Character.isWhitespace(c) || (c>='0' && c<='9'))
                break;
            currencyLength++;
            i++;
        }
        if(currencyLength>0){
            currency=s.substring(currencyStart,
                    currencyStart+currencyLength);
        }
    }
    if(i!=s.length())
        throw new NumberFormatException("Invalid currency string");
    CurrencyValue cv=new CurrencyValue();
    cv.setCurrency(currency);
    cv.setDecimalPart(decimalPart);
    cv.setIntegerPart(integerPart);
    return cv;
}