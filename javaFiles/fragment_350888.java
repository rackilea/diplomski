public void onDataReceived(int id, byte[] data)
{
    //cast added to keep original code structure 
    //I recomend define the bis attribute as the MyBAIsWrapper type in this case
    ((MyBAIsWrapper)bis).renew(data);
}