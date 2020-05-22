class kbc {

    private static boolean taken[];
    private static boolean found = false;
    public static void main (String args[])  throws Exception {    
        int n1=124;
        int n2=320;
        String s1 = "";
        s1+= n1;
        String s2 = "";
        s2+= n2;
        if(s2.length()>s1.length())
            System.out.println("Invalid");
        else {
            taken = new boolean[s1.length()];
            char[] ad = new char[s1.length()];
            char[] tempArray = s1.toCharArray();
            Arrays.sort(tempArray);
            s1 = new String(tempArray);
            printSmallest(ad, s1, n2,0);
        }
    }
    static void printSmallest(char[] a, String s1, int n2, int k) 
    {
        if(found)
            return;
        int snum;
        int saved= Integer.MAX_VALUE;
        String s="";
        if (k == a.length) 
        {
            for (int i = 0; i < a.length; i++) 
            {
                s=s+a[i];
            }
            snum = Integer.parseInt(s);
            if(snum>n2){
                if(snum<saved){
                    saved=snum;
                    found = true;
                }
                System.out.println(saved);
            }

        }
        else{ 
            for (int i = 0; i < a.length; i++){
                if(!taken[i] && !found) {
                    taken[i] = true;
                    a[k] = s1.charAt(i);
                    printSmallest(a, s1, n2, k + 1);
                    taken[i] = false;
                }
            }
        }  
    }
}