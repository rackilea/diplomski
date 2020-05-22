//regulates the first value
for (int i = 0; i < input.length-1; i++)
{
    int min = i;   

    //checks remaining values for min
    for (int j = i+1; j < input.length; j++)
    {
        if (!(input[j] instance Boat)){ //check to use only Boat objects
            continue;
        } //now that you are sure it's a Boat object - cast the reference to use it as a Boat object reference
        if (((Boat)input[j]).getBoatLength().compareToIgnoreCase(((Boat)input[min]).getBoatLength())<0)
        {
            min = j;
        }  
    }
    //swaps values
    Vehicle temp = input[i];
    input[i] = input[min];
    input[min] = temp;
}