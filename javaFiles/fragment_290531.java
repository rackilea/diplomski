public static void main(String[] args) {
    // Permutes to get all possible Strings of size 5
    System.out.println(permute(5));
}

public static List<String> permute(int n) {
    List<String> result = new ArrayList<>();
    // Initialize the SringBuilder with ABC and the target size
    permute(n, result, 0, new StringBuilder(n).append("ABC"));
    return result;
}

public static void permute(int n, List<String> result, int start, StringBuilder builder) {
    if (builder.length() == n) {
        // The String is complete so we add it to the combination list
        result.add(builder.toString());
        return;
    }
    // Iterate from start to the length (included) of StringBuilder
    for (int j = start; j <= builder.length(); j++) {
        // Insert X at the position j
        builder.insert(j, 'X');
        // Continue adding X but starting from next index
        permute(n, result, j + 1, builder);
        // Remove X at the position j
        builder.deleteCharAt(j);
    }
}