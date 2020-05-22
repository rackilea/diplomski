// count the rightmost point for each circle;
   for (int i = 0; i < N; i++) {
        int right;
        if (N - 1 >= A[i] + i) { 
            right = i + A[i];
        } else {
            right = N - 1;
        }
        sum[right]++;
    }
    //  summing up since `i` cannot be reached/intersected from the left, there is no way the `right-er` can; 
    for (int i = 1; i < N; i++) {
        sum[i] += sum[i - 1];
    }
    // get the total amount of combinations;
    int result = N * (N - 1) / 2;
    for (int j = 0; j < N; j++) {
        int left; // the leftmost point the current circle can reach;
        if (j - A[j] < 0) { // avoid invalid;
            left = 0;
        } else {
            left = j - A[j];
        }
    if (left > 0) { // if it's valid, sum[left-1] will be the un-intersected, subtract it;
                result -= sum[left - 1];
            }
     }