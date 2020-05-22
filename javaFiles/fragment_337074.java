for (row = 0; row < m1rows; row++) {
        for (col = 0; col < m1cols; col++) {
            // creating thread for multiplications
            thrd[threadcount] = new Thread(new MultiplicationThreading(row, col, MatrixA, MatrixB, MatrixC));
            thrd[threadcount].start(); //thread start
            threadcount++;
        }
    }
    for (Thread thread : thrd) {
      thread.join();
    }