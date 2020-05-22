public class SearchSortAlgorithms<T> implements SearchSortADT<T>
{
   //Initialize swap counter
   int bubbleSwaps = 0;

   //Bubble sort algorithm.
   //Postcondition: list objects are in ascending order.
    public void bubbleSort(T list[], int length)
    {

        for (int iteration = 1; iteration < length; iteration++)
        {
            for (int index = 0; index < length - iteration;
                         index++)
            {
                Comparable<T> compElem =
                       (Comparable<T>) list[index];


                if (compElem.compareTo(list[index + 1]) > 0)
                {
                    T temp = list[index];
                    list[index] = list[index + 1];
                    list[index + 1] = temp;
                    this.bubbleSwaps++;
                }
            }
        }
    }

public int getBubbleSwaps(){
     return this.bubbleSwaps;
}
}