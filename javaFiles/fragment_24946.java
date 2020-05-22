String s = "Hi/I/Jack/there";

    for(int i=0,count=0;i<s.length();i++)
    {
        if(s.charAt(i)=='/')// if the i'th element is '/'
        {
            count++;
            if(count==2)//it's second '/'
            {
                //separate to two part by second '/' and add what you want at middle
                s = s.substring(0,i) + "am" +s.substring(i+1,s.length());                    
            }
        }
    }