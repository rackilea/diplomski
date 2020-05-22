static long substrCount(int n, String s) {
    long cnt = 0;
    int[] left  = new int[n];
    int[] right = new int[n];
    int len = s.length();
    for(int i=0;i<len;++i){
        left[i] = 1;
        if(i > 0 && s.charAt(i) == s.charAt(i-1)) left[i] += left[i-1];
    }

    for(int i=len-1;i>=0;--i){
        right[i] = 1;
        if(i < len-1 && s.charAt(i) == s.charAt(i+1)) right[i] += right[i+1];
    }

    for(int i=len-1;i>=0;--i){
        if(i == 0 || i == len-1) cnt += right[i];
        else{
            if(s.charAt(i-1) == s.charAt(i+1) && s.charAt(i-1) != s.charAt(i)){
                cnt += Math.min(left[i-1],right[i+1]) + 1;
            }else if(s.charAt(i) == s.charAt(i+1)) cnt += right[i];
            else cnt++;
        }
    }

    return cnt;
}