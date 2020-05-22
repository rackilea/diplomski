private static int countZeros(int[] f) {
    for (int i=f.length-1; i>=0; i--){
        if(f[i]!=0 && i>0 && f[i-1]==0){
            i--;
            int count=0;
            while(i>=0 && f[i]==0){
                i--;
                count++;
            }
            if(i==0)
                return null;
            else
                return count;
        }
    }
    return null;
}