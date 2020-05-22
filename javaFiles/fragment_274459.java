public void reHash(ArrayList<LinkedList<String>> oldHashTable)
    {
        ArrayList<LinkedList<String>> newHashTable = new ArrayList(oldHashTable.size()*2);

        //rehash values in oldHashTable
        for (int i = 0; i < (oldHashTable.size()); i++)//loop old hashTable.size number of times 
        {
            bucket = oldHashTable.get(i);//bucket = linkedList at oldHashTable

            if (bucket != null)//if hashTable linkedList bucket element contains elements 

            {
                newBucket = new LinkedList<String>();
                for (int j = 0; j < bucket.size(); j++)//loop through it 
                {
                    if(bucket.get(j) != null)//looking for items
                    {
                        int reHashValueIndex = hash(bucket.get(j)); //rehash element 
                        newBucket.add(reHashValueIndex, bucket.get(j));//insert values into new table at new rehashed index
                    }
                }
            }
            newHashTable.add(newBucket);
        }
        //increment expand variable by one
        expand++;
    }