if(arr.length == 0)
    return false;

if(arr[0].compareTo(searchValue) == 0)
    return true;

return searchItem(Arrays.copyOfRange(arr, 1, arr.length), searchValue);