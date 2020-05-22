public static void main(String[] args)
    {
        int i=0;
        int len = args.length;   //use length only in this case;
        System.out.println(len); // this will return it properly now
        while(i<len)
        {
            System.out.println(args[i]);
            i++;
        } 
    }