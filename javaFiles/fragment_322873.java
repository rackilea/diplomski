public static boolean startOther(String left, String right) {
    if (left == null || right == null || left.equals(right)) {
        return false;
    }
    int rightSubstringInLeft = left.lastIndexOf(right);
    int leftSubstringInRight = right.lastIndexOf(left);

    if(rightSubstringInLeft != -1) {
        return rightSubstringInLeft == left.length() - right.length();
    } else if(leftSubstringInRight != -1) {
        return leftSubstringInRight == right.length() - left.length();
    } else {
        return false;
    }
}