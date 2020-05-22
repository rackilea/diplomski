// Setup
char[] arr = { 'A', 'E', 'D' };

// Generate all subsequences
List<char[]> result = new ArrayList<>();
for (int start = 0; start < arr.length; start++) {
    for (int end = start + 1; end <= arr.length; end++) {
        result.add(Arrays.copyOfRange(arr, start, end));
    }
}

// Print result
result.forEach(a -> System.out.println(Arrays.toString(a)));