long permutations = 1;

for (int i = 0; i < letter.size(); i++)
{
    int setcount = letter[i].size();
    if (setcount == 0)
    {
       continue;
    }
    permutations *= setcount;
}

for (long p = 0; p < permutations; p++)
{
    long index = p;
    String s = "";

    for (int i = 0; i < letter.size(); i++)
    {
        if (letter[i].size() > 0)
        {
            ArrayList<Letter> innerIndex = index % letter[i].size();
            index /= letter[i].size();

            // append letter[i].get(innerIndex) to s, then append a semi-colon 
        }
    }

    System.out.println(s);
}