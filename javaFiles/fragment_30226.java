if(name[j].compareTo(name[i]) < 0)
{
    temp = name[i];
    name[i] = name[j];
    name[j] = temp;
    long ntemp = number[i];
    number[i] = number[j];
    number[j] = ntemp;
}