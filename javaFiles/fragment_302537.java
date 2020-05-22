public static String parseInt(int integer)
{
    boolean ifNegative = integer<0;
    boolean ifMin = integer == Integer.MIN_VALUE;
    StringBuilder builder = new StringBuilder();        
    integer = ifNegative?(ifMin?Integer.MAX_VALUE:-integer):integer;    
    List<Integer> list = new LinkedList<Integer>(); 
    int remaining = integer;
    int currentDigit = 0 ;

    while(true)
    {
        currentDigit = remaining%10;
        list.add(currentDigit);
        remaining /= 10;
        if(remaining==0) break;
    }

    currentDigit = list.remove(0);
    builder.append(ifMin?currentDigit+1:currentDigit);
    for(int c : list)
        builder.append(c);
    builder.reverse().insert(0, ifNegative?'-':'+');
    return builder.toString();
}