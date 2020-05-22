public static void main(String[] args){
    explode("a,b,c,d", ',');
}

public static void explode(final String string, final char delimiter){
    int length = 1;
    for(final char c : string.toCharArray())
        if(delimiter == c)
            length++;
    if(length == 1)
        return;
    final String[] array = new String[length];
    int index, prev = 0, i = 0;
    while((index = string.indexOf(delimiter, prev)) > -1){
        array[i++] = string.substring(prev, index);
        prev = index+1;
    }
    array[i] = string.substring(prev);
    System.out.println(length);
    for(final String s : array)
        System.out.println(s);
}