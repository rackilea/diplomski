while(i <= gt)
    {
        if(array[i] < array[lt])
            swap(array, lt++, i++);
        else if(array[i] > array[lt])
            swap(array, i, gt--);
        else
            i++;
    }