public static void foo(int[] arr)
    {
        int i = 0;
        while(i != arr.Length)
        {
            if(arr[i] == 4 || arr[i] == 9)
            {
                if(arr[i] == 4)//find the next 9 and swap with arr[i+1]
                {
                    int j = i+1;
                    while(arr[j] != 9 && j < arr.Length)
                    {
                        j++;//inc j while arr[j] is not 9
                    }
                    if(arr[j] == 9)
                    {
                        int temp = arr[i + 1];
                        arr[i + 1] = arr[j];
                        arr[j] = temp;
                        i += 2; //skip over '9' that just replaced
                    }
                    else
                    {
                        i++;// didn't find '9' so move on to next index 
                    }
                }
                else if(arr[i] == 9) //find the next '4' and swap with the number that comes after it, and don't increament i if found..
                {
                    int j = i + 1;
                    while (arr[j] != 4 && j < arr.Length)
                    {
                        j++;//inc j while arr[j] is not '4'
                    }
                    if(arr[j] == 4 && j < arr.Length)
                    {
                        int temp = arr[i];
                        arr[i] = arr[j+1];
                        arr[j+1] = temp;
                    }
                    else
                    {             
                        i++;  // didn't find '4' so move on to next index             
                    }
                }
            }
            else // not 4 or 9
            {
                i++; //move on to next index
            }
        }
    }