String Lab = "thorax1  [00400 - 00479]"
                + "su  [00100 - 0022200su] "
                + "head1  [00100 - 00228] "
                + "head1  [00100 - 00228] "
                + "thorax1  [00400 - 00479] " +
                    "lab66  [lab661]";


        int first = 0;
    int last = 0;
    while(true)
    {   
        first = Lab.indexOf("[", first) + 1;
        last = Lab.indexOf("]", first);
        if(first <= 0)
        {
            break;
        }
        System.out.println(Lab.substring(first, last));
    }