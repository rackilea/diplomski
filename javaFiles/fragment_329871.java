Integer[]myCurrentData={1,2,3,4,5,6}; 

    int startIndex = 0, endIndex = myCurrentData.length;

    ArrayList<Integer> rearrangedData = new ArrayList<>();

    //Let add a for loop for this example >You can change asper your requirement
       for(int i=0;i<myCurrentData.length;i++)
          {     
            if (rearrangedData.size() % 2 == 0) //if even number add start index
               {

                   rearrangedData.add(myCurrentData[startIndex]);

                     startIndex++;

                } else {
                        endIndex--; 

                       rearrangedData.add(myCurrentData[endIndex]);


                }
           }
 //Just to print the data
    String printString="[";
    for(int i=0;i<rearrangedData.size();i++)
    {
        printString=printString+rearrangedData.get(i)+",";
    }
    printString=printString+"]";
    System.out.println("Rearranged Data"+printString);