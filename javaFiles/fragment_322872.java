public static boolean startOther(String left, String right) {
    if (left == null || right == null || left.equals(right)) {
        return false;
    }
    int rightSubstringInLeft = left.indexOf(right);
    int leftSubstringInRight = right.indexOf(left);

    if(rightSubstringInLeft != -1) {
        return left.substring(rightSubstringInLeft).equals(right);
    } else if(leftSubstringInRight != -1) {
        return right.substring(leftSubstringInRight).equals(left);
    } else {
        return false;
    }
}