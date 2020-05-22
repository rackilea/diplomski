if(str.charAt(i-1) == str.charAt(i+1)){ // you will add checks for boundaries
    int min_count = Math.min(left[i-1],right[i+1]);
    for(int j=min_count;j>=1;--j){
        set.add(str.substring(i-j,i+j+1));
    }
}