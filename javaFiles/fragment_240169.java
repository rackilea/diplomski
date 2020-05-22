import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort 
{
    private ArrayList<Integer> basicArrayList = new ArrayList<Integer>();
    Scanner input = new Scanner(System.in);
    private int numbersToSort;

    public void doMergeSort(int firstIndexOfArrayList,int lastIndexOfArrayListB, ArrayList<Integer> arrayList)
    {
        if(firstIndexOfArrayList<lastIndexOfArrayListB && (lastIndexOfArrayListB-firstIndexOfArrayList)>=1)
        {
            int mid = (lastIndexOfArrayListB + firstIndexOfArrayList)/2;
            doMergeSort(firstIndexOfArrayList, mid, arrayList);
            doMergeSort(mid+1, lastIndexOfArrayListB, arrayList);
            Scal(firstIndexOfArrayList,mid,lastIndexOfArrayListB, arrayList);            
        }       
    }   

    public void Scal(int firstIndexOfArrayList,int lastIndexOfArrayListA,int lastIndexOfArrayListB, ArrayList<Integer> arrayList)
    {
        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();

        int leftIndex = firstIndexOfArrayList;
        int rightIndex = lastIndexOfArrayListA+1;

        while(leftIndex<=lastIndexOfArrayListA && rightIndex<=lastIndexOfArrayListB)
        {
            if(arrayList.get(leftIndex)<=arrayList.get(rightIndex))
            {
                mergedSortedArray.add(arrayList.get(leftIndex));
                leftIndex++;
            }
            else
            {
                mergedSortedArray.add(arrayList.get(rightIndex));
                rightIndex++;
            }
        }

        while(leftIndex<=lastIndexOfArrayListA)
        {
            mergedSortedArray.add(arrayList.get(leftIndex));
            leftIndex++;
        }

        while(rightIndex<=lastIndexOfArrayListB)
        {
            mergedSortedArray.add(arrayList.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = firstIndexOfArrayList;

        while(i<mergedSortedArray.size())
        {
            arrayList.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }

    public void setSize() 
    {
        System.out.println("Enter the number of elements to sort: ");
        this.numbersToSort = input.nextInt();
    }

    public int getSize() 
    {
        return numbersToSort;
    }

    public void setData() 
    {
        System.out.println("Enter the numbers: ");
        for (int i = 0; i < numbersToSort; i++) 
        {
            int number;
            number = input.nextInt();
            basicArrayList.add(number);
        }
    }

    public void getTable() 
    {
        System.out.println(basicArrayList.toString());
    }

    public void runSort(ArrayList<Integer> arrayList)
    {
        doMergeSort(0, this.numbersToSort-1, arrayList);
    }

    public static void main(String[] args) 
    {
        MergeSort output = new MergeSort();
        output.setSize();
        output.setData();
        output.runSort(output.basicArrayList);
        output.getTable();
    }
}