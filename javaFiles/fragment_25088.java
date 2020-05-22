public void countsubString(String str,String findString){
    int count=0;
    String strArr[]=str.split(" +");
    for(String str: strArr){
    if(str.equals(findString)){ 
        count++;
     }
    }
    System.out.println(count);
 }