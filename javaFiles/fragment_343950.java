Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++)
        for (int j = i + 1; j < arr.length; j++)
            if (arr[i] == arr[j])
            {
                while (j < arr.length && arr[i] == arr[j])
                    j++;
                System.out.println(arr[i]);
                i = j;
            }