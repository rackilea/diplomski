for(int i=0;i<AsciiConvert.length;i++)
        {
            int j = 0 , k = 0;
            char ch1=AsciiConvert[i];
            if(ch1 == 48)
            {
                j = 0;
            }
            if(ch1 == 49)
            {
                j = 1;
            }
            System.out.print(ch1 + "\t ");
            for(int p=i;p<=i;p++)
            {
                char ch2=AsciiConvert2[p];
                if(ch2 == 48)
                {
                    k = 0;
                }
                if(ch2 == 49)
                {
                    k = 1;
                }

                System.out.print(ch2);

                if(j == 1 && k == 1)
                {
                    String conj1 = "1 ";
                    output =(output + conj1);
                    System.out.print("\t   " + conj1 + "\n");
                }
                else
                {
                    String conj2 = "0 ";
                    output =(output + conj2);
                    System.out.print("\t   " + conj2 + "\n");
                }
                continue test;
            }
        }