static int isBean(int...a){
    int isbean=1;
    for (int i = 0; i < a.length; i++) {

    boolean isFound = false;
        for (int j = 0; j <a.length; j++) {
            if(a[i]+1==a[j]||a[i]-1==a[j]){ 
            isFound = true;
            break;
            }
        } 
        System.out.println(" ");
        if(!isFound){
                isbean= 0;
                break;
            }
    }

    return isbean;
}