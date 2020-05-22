CarsLines [] newArr= new CarLines[count];
int index = 0;
for(int i = 0; i< this.cars,length; i++)
{
    if (this.cars[i] != null) { // Only pass in the non-null values
        newArr[index] = this.cars[i]; 
        index++;
    }
}
this.cars= newArr;