List<Integer> tempNumbers = new ArrayList<Integer>();
...

} else {
    int result = fibonacci(n - 1) + fibonacci(n - 2);
    tempNumbers.add(result);
    return result;
}