public String toString(){
    String result = "[";
    for(int i = 0;i<=size-1;i++){
        int temp = array.get(i);
        result += (char)temp;
    }
    return result += "]";
}