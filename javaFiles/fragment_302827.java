private static void merge(String[] data, int first, int n1, int n2)
    {
        String[] temp = new String[n1 + n2];
        int copied = 0;
        int copied1 = 0;
        int copied2 = 0;

        while ((copied1 < n1) && (copied2 < n2))
        {
            if (data[first + copied1].compareTo(data[first + n1 + copied2]) < 0)
                temp[copied++] = data[first + (copied1++)];
            else
                temp[copied++] = data[first + n1 + (copied2++)];
        }

        while (copied1 < n1)
            temp[copied++] = data[first + (copied1++)];
        while (copied2 < n2)
            temp[copied++] = data[first + n1 + (copied2++)];

        for (int i = 0; i < copied; i++)
            data[first + i] = temp[i];

    }