public static int[] splitString(String str, int length){

    int size=str.length()/length;
    if( str.length() % length != 0)
       size++;

    int[] arr = new int[size];
    int a=0;
    for (int i= 0; i < str.length(); i+=length) {
        if(i+length < str.length())
            arr[a++]=Integer.parseInt(str.substring(i, i+length));
        else  
            arr[a++]=Integer.parseInt(str.substring(i,  str.length()));
    }
    return arr;
}