for( int i = 1; i < contributorList.size(); i++)
{
    int j = i;
    Contributor tmp;
    while( j > 0 && contributorList.get(j-1).getName().compareTo( contributorList.get(j).getName()) > 0)
    {
        tmp = contributorList.remove( j);
        contributorList.add( j-1, tmp);
        j = j - 1;
    }
}