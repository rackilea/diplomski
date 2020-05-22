if (list[j].compareTo(list[j+1]) > 0)
{
    temp = list[0];
    list[0] = list[1];
    list[1] = temp;

    testing = true;   
}