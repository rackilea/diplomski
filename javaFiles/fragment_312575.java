if (i >= 0) {
            char x = arr[i];
            for (int k = pos; k < i; ++k) {
                char y = arr[k];
                arr[k] = x;
                x = y;
            }
            arr[i] = x;
            ++pos;
        }