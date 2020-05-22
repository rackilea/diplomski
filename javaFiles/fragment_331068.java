int mail=0, tel=0;
    for (int i=0; i<adr.length; i++)
    {
        if(adr[i].substring(0, 4).equals("Mail")) {
            mail++;
        }
        else tel++;
    }
    String [] m = new String [mail];
    String [] t = new String [tel];
    int mIndex =0, tIndex = 0;

    for(int i=0; i<adr.length; i++) {
        if(adr[i].substring(0, 4).equals("Mail")) {
            m[mIndex]=adr[i].substring(4);
            mIndex++;
        }
        else
        {
            t[tIndex]=adr[i].substring(4);
            tIndex++;
        }
        System.out.println(adr[i].substring(0, 4));
    }
}