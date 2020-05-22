public String methodName(String input){
     String arr[] = new String[3]; // size ur wish
    arr=input.split("-"); //splits the input with the - delimiter into array of strings
    String name=arr[1]; //contains character
    int year=Integer.parseInt(arr[2]); //contains year
    if(year<2000)
       return  name + " 90's";
    else if(year>=2000 && year<2006)
        return name + " early 2000's";
    else if(year>=2006)
       return name + " latest";
    else 
       return "wrong format";
 }