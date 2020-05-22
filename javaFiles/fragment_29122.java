System.out.println("Before Sorting the Numbers: " + intList);
        List<Integer> sortList = new ArrayList<Integer>();
        int minVal;
        int index=0;
        int size = intList.size();
        for (int i = 0; i < size; i++)
        {   minVal=Integer.MAX_VALUE;
            for (int j = 0; j < intList.size(); j++)
            {
                if(intList.get(j) < minVal){
                    index=j;
                    minVal=intList.get(j);
                }
            }
            intList.remove(index);
            sortList.add(minVal);
        }
        System.out.print("After Sorting the Numbers: "+ sortList);