public boolean isUnique()
{
    ArrayList<Integer> checkNumbers = new ArrayList();

    for(int i = 1; i<=numbers.size(); i++)
    {
        if(numbers.contains(i))
        {
           if (!checkNumbers.contains(i)) 
             checkNumbers.add(i);
           else 
            return false; 
        }
        else{
            return false;
        }           
    }

    return true;
}