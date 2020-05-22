if(ta.getText().length() != 0 && t1.getText().length() != 0)
        {
            char c1[] = ta.getText().trim().toCharArray();
            char c2[] = t1.getText().trim().toCharArray();

            k=getStart(startFlag, c1.length);

            for(int i=0;i<c2.length;i++)
            {
                if(c2[i] != c1[start++])
                {
                    start = getStart(startFlag, c1.length);
                }
                else 
                    countFlag++;
            }

            if(countFlag==c2.length)
            {
                ta.select(k,c2.length);
                startFlag++;
            }

        }