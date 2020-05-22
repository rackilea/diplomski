String str="This; is; my; test;";
    String[] strArr=str.split(";");
    for(int i=0;i<strArr.length;i++)
    {
        System.out.println("Str:::"+strArr[i]);
     // add strArr[i] to an array or go through Arrays.toString()
    }