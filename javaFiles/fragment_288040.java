while (i <= length) {
        if (array[i] == ' ') {
            reverseString(array, start, i - 1);
            start = i + 1;
        }
        i++;
    }