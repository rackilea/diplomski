public void itemsDelete(int x)
{
Item[] temp=new Item[items.length-1];

//This variable will keep track of the index in the temp array
int j = 0;

//for each of the items in the input array...
for(int i=0;i<items.length;i++)
{
    if(i!=x)
    {
        temp[j]=items[i];
        //We've copied a value so increment the temp index...
        j++;
    }
}

items = temp;
}