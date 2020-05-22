private double evalLeftToRight(String text){
    double result = 0.0f;
    char actualOperant = ' ';
    Pattern pattern = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*/]))");
    Matcher m = pattern.matcher(text);  
    while(m.find()) {
        String part = m.group();
        if     (part.equals("+")) actualOperant = '+';
        else if(part.equals("-")) actualOperant = '-';
        else if(part.equals("*")) actualOperant = '*';
        else if(part.equals("/")) actualOperant = '/';
        else{
            double actualNumber = Double.parseDouble(part);
            switch(actualOperant){
                case ' ': result = actualNumber; break;
                case '+': result += actualNumber; break;
                case '-': result -= actualNumber; break;
                case '*': result *= actualNumber; break;
                case '/': result /= actualNumber; break;
            }
        }
    }
    return result;
}