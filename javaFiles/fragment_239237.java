for(int i=0;i<input.length;i++) {
    st5 = new StringTokenizer(input[i],",");
    int tokCount = st5.countTokens();
    int tkcount = 0;

    while(st5.hasMoreElements()) {
        tkcount++;
        st5.nextToken();

        if((tokCount - 2) == tkcount){
            String str = st5.nextToken();

            if(str.indexOf("-mCont") == -1)
                break;

            String mcount = str.substring(str.indexOf("-mCont")+1);
            mcount = mcount.replace("mCont "," ");

            System.out.println(mcount);
       }
    }
}