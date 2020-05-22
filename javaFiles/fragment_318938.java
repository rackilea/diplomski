class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {

        int array[]={1,2,3,4,5};
        String s1="PPNPN";

        char []array1=s1.toCharArray();
        String out[] = new String[array1.length];
        for(int i = 0; i < array1.length; i++)
        {
            out[i] = array1[i]+" -> "+array[i];
        }


        for (String val : out) 
        {
            System.out.println(val);
        }   
    }
}