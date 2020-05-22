int maxPosition = 0;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[maxPosition] <= arr[i])
                maxPosition = i;
        }
        return maxPosition;