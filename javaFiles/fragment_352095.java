public static <T> int getLength(T[] arr){
    int count = 0;
    for(T el : arr)
        if (el != null)
            ++count;
    return count;
}