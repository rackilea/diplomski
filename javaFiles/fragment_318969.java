X[num1] = x;
    Y[num1] = y;
..
           // Out of bounds risky here, make sure you have enough elements before calling i+1 index.
            System.out.println(X[i]+" "+Y[i]+" "+X[i+1]+" "+Y[i+1]);
...