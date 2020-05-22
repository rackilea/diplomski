if (root == null) {
    throw new IllegalArgumentException("Root Node must have a value");
}

if (root.getLeft() == null && root.getRight() == null) {
    try {
       return Float.parseFloat(root.getItem().toString()); 
    } catch (NumberFormatException parseError) {
       throw new NumberFormatException("Leaves must be numeric");
    }
}

if (root.getLeft() == null || root.getRight() == null) {     
    throw new IllegalArgumentException("Operator missing operands");
}