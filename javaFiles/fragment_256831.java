private static String reversePartially(String initial, int target) {
    return reversePartially(initial, target, target);
}

private static String reversePartially(String initial, int index, int target) {
    // if we are at the target index put the character at the front
    if(index == target) return initial.charAt(target) + reversePartially(initial, index + 1, target);
    // if we are in the second part return the characters reversed
    if(index > target) return reversePartially(initial, index + 1, target) + initial.charAt(index);
    // base condition
    if(index == initial.length()) return "";
    return "";
}