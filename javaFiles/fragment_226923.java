public ArrayList<Integer> getRandomPermutation() 
{
ArrayList<Integer> unused = new ArrayList<>();
.
.
.
}

public void nextPermutation()
{
for(int i = 0; i < size; i++) //loop for permutation 10 times
    {
    for(Integer item : getRandomPermutation()) 
        {
        System.out.print(item + " ");
        }
    System.out.println();
    }
}