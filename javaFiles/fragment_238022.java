public static String toString(int[] a, char v, char h, String mellomrom){
    StringBuilder sb = new StringBuilder();
    sb.append(v);
    if(a.length != 0){
        for(int i = 0; i < a.length-1; i++){
                sb.append(a[i]).append(mellomrom); 
        }
        sb.append(a[a.length-1]);
    }
    sb.append(h);
    return sb.toString();
}