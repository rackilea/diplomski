public void insertionSort(ArrayList<String> emailrecords)   //insertion sort, pass by parameter?
    {    
    int i,j;
    String key;
    ArrayList<String> inputArray=emailRecords;

    for (j=1; j<inputArray.size(); j++) 
        {
            key = inputArray.get(j);
            i = j - 1;
                while (i >= 0)
                {
                    if (key.compareTo(inputArray.get(i)) > 0) {
                    break;
                }
             String element=inputArray.get(i+1);             //here
             inputArray.set(i+1,inputArray.get(i));          //here
             inputArray.set(i,element);                      //here
             i--;
         }
         key=inputArray.get(i+1);
    }
    }
}