for (int i = 0; i < numList.length; i++) {
            minIndex = findMin(numList,i,numList.length);
            temp=numList[i];
            numList[i]=numList[minIndex];
            numList[minIndex]=temp;
        }