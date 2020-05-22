public static boolean compareEqual(Object left, Object right) {
    if (left==right) return true;
    Class<?> leftClass = left==null?null:left.getClass();
    Class<?> rightClass = right==null?null:right.getClass();

    // ....
}