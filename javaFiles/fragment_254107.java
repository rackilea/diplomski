public static void main(String[] args) {
    String s = "Sssgs";
    char[] ch = s.toCharArray();
    int[] count = new int[20];

       for(int i=0;i<ch.length;i++)    
        {
            count[i]=0;
            for(int j=i;j<ch.length;j++)
            {
                if(ch[i]==ch[j])
                {
                    count[i]++;
                } else {
                    break;
                }
            }
        }

        //Prints Distinct char
        for(int i=0;i<ch.length;i += count[i])
        {
            System.out.print(ch[i] + "" +count[i]);
        }
}