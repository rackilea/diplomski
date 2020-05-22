public static void main(String[] args){
    int a [] = {2,4};
    int b [] = {16,48,96};
    int c [] = {4,8,12};
    int result [] = {0,0,0};
    for(int i=0;i<c.length;i++){
        boolean check = true;

        for(int j=0;j<a.length;j++){
            if(c[i]%a[j]!=0){
                check = false;
                break;
            }
        }
        for(int k=0;k<b.length;k++){
            if(c[i]%b[k]!=0){
                check = false;
                break;
            }
        }
        if(check){
            result[i] = c[i];
        }
    }
}