public static void main(String[] args) {
        byte[] barray= new byte[99999999];
        barray[0]=72;
        barray[1]=101;
        barray[2]=108;
        barray[3]=108;
        barray[4]=111;
        barray[5]=33;
        for (int k = 6; k < barray.length; k++) {
            barray[k]=0;
        }
        try {
            long a=System.nanoTime();
            convertFromByteArray(barray);
            long b=System.nanoTime();
            long tot_1=b-a;
            long c=System.nanoTime();
            convertFromByteArray2(barray);
            long d=System.nanoTime();
            long tot_2=d-c;
            System.out.println(tot_1 +" - "+tot_2+" "+(tot_1*1.0/tot_2));

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static String convertFromByteArray(byte[] a) throws UnsupportedEncodingException{
        String s = new String(a,"UTF-8");
        return s.trim();
    }
    public static String convertFromByteArray2(byte[] barray) throws UnsupportedEncodingException {
        int i=0;
        while(barray[i++]!=0);

        return new String(barray,0,i-1,"UTF-8");
    }