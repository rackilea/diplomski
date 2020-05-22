if(query[0].equals("1"))                            //Flip the bit if query[0]=1
    {
        if(binArr[Integer.parseInt(query[1])-1]=='1')    //take position(query[1]) as int and flip
            binArr[Integer.parseInt(query[1])-1]='0';
        else
            binArr[Integer.parseInt(query[1])-1]='0';
 }