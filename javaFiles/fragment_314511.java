Double count = 1.0;
        for(int i = 0; i  < sample.size()-1; i++)
        {
            Double first = sample.get(i);
            Double second = sample.get(i+1);

            if(first.equals(second))
            {
                sample.set(i, count);
                if((i + 2) == sample.size())
                {
                   sample.set((i+1), count);
                }
            }
            else
            {
                sample.set(i, ++count);
                if((i + 2) == sample.size())
                {
                   sample.set((i+1), count);
                }
            }

        }