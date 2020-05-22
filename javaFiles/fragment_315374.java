public class TestClass {

    static ArrayList<ArrayList<Integer>> fullData = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
    static int listTwocounter = 0;

    public static void main(String[] args) {

        int listOne[] = {1, 2, 3};
        int listTwo[] = {7, 8, 9};
        int listOneCombination = 2;
        int listOneSize = 3;

        printCombination(listOne, listTwo, listOneSize, listOneCombination);
    }

    static void printCombination(int listOne[], int listTwo[], int n, int r)
    {
        // A temporary array to store all combination one by one
        int data[] = new int[5];

        // Print all combination using temprary array 'data[]'
        combinationUtil(listOne, listTwo, data, 0, n-1, 0, r);

        //fullData
        // Add elements from 2nd list
        for (ArrayList<Integer> temp : fullData)
        {
            for(int i=0; i<listTwo.length; i++)
            {
                ArrayList<Integer> local = new ArrayList<>();
                for(int x : temp)
                    local.add(x);

                local.add(listTwo[i]);
                finalList.add(local);
            }
        }
    }

    static void combinationUtil(int listOne[], int listTwo[], int data[], int start, int end,
                         int index, int r)
    {
        ArrayList<Integer> tempData;

        if (index == r)
        {
            tempData = new ArrayList<>();
            for (int j=0; j<r; j++)
                tempData.add(data[j]);

            fullData.add(tempData);
            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = listOne[i];
            combinationUtil(listOne, listTwo, data, i+1, end, index+1, r);
        }
    }
}