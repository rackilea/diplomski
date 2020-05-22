String a="stack overflow";
        String b="tack";

        // solution 1 

        System.out.println(a.contains(b));




    // soultion 2

        int counter=0;
        for(int i=0;i<b.length();i++)
        {

            for(int j=0;j<a.length();j++)
            {
                if(b.substring(i,i+1).equals(a.substring(j,j+1)))
                {

                    counter++;
                }
            }

        }
        if(counter>=b.length())
        {
            System.out.println("string found ");
        }
        counter=0;
    // solution 3   fuzzy one 
        int index=0;
        for(int i=0;i<b.length();i++)
        {
            index=a.indexOf(b.substring(i,i+1));
            if(index!=-1)
            {
                counter++;

            }



        }
        if(counter<b.length())
        {

            System.out.println("string not found ");
        }

        else 
        {
            System.out.println("string found ");
        }