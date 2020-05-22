if (array[mid] < key)
    {
        return bSearch(array, mid+1, high, key);
    }
    else if (array[mid] > key)
    {
        return bSearch(array, low, mid-1, key);
    }