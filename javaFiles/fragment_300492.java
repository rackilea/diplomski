Long.MIN_VALUE == -Long.MIN_VALUE;
0.0d == -0.0d
0.0f == -0.0f
Double.NaN != Double.NaN
Float.NaN != Float.NaN
Double.compare(Double.NaN, 0) == 1 but Double.NaN > 0 is false
Float.compare(Float.NaN, 0) == 1 but Float.NaN > 0 is false