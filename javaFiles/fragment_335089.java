//in this example a[] and b[] are same length
int[] a = ...
int[] b = ...

int[] result = new int[a.length];

IntStream.range(0, a.length)
         .forEach(i -> result[i] = a[i] * b[i]);