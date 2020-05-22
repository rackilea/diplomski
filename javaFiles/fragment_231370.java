public static boolean equalArrays(int [] a, int [] b) {
    if(a == b){
        return true;
    }

    if(null == a || null == b){
        return false;
    }

    if(a.length != b.length){
        return false;
    }

    for(int i = 0; i < a.length ; i++){
        if (a[i]!=b[i]){
            return false;
        }
     }

    return true;
}