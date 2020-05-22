public boolean isUnique()
    {

     if (numbers.size()<n)
        return false;  

        for(int i = 1; i<=numbers.size(); i++)
        {
            if(!numbers.contains(i))
              return false; 

        }

        return true;
    }