static Integer function(int [] arr){
    int closest=arr[0];
    for(int i=1;i<arr.length;i++){
        if(Math.abs(arr[i])<closest){
            arr[i]=closest;
        }
        else if(arr[i]==closest){
            return null;
        }
    }
    return closest;
}