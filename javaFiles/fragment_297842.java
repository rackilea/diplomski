static int binarySearch(int[] array, int left, int right, int key,int sorting) 
    {
        if (left > right) 
        {
          return -1;
        }

        int mid = (left + right) / 2;

        if (array[mid] == key) 
        {
          return mid;
        }

        if(sorting == 2)   // if array is sorted in descending order
        {
            if (array[mid] > key) 
            {
              return binarySearch(array, mid+1, right, key,sorting );
            }
            return binarySearch(array, left, mid-1, key,sorting );
        }
        else // if array is sorted in ascnending order
        {
            if (array[mid] > key) 
            {
                return binarySearch(array, left, mid - 1, key,sorting );
            }

            return binarySearch(array, mid + 1, right, key,sorting );
        }
    }