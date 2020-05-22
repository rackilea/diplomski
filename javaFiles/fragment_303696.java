boolean previousIterationSwap = false;
        final int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = 0; i < A.length - 1; i++) {
            // After the first iteration check if previous iteration had any
            // swap
            if (i > 0 && !previousIterationSwap) {
                break;
            }
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    previousIterationSwap = true;
                    final int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                } else {
                    previousIterationSwap = false;
                }
            }
        }