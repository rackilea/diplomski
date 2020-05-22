// return empty string if we have reached the end of
// either sequence
if (m == 0 || n == 0) {
    return "";
}
...

// if last character of X and Y matches
if (Objects.equals(x[m - 1], y[n - 1])) {
...