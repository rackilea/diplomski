int eqDepth(Node n) {
    if (n == null) return 0;     // This is a leaf, its subtree depth is zero
    int dLeft = eqDepth(n.left); // Make two recursive calls
    int dRight = eqDepth(n.right);
    // If one of the depths is negative, or the depths are different,
    // report it by returning negative 1:
    if (dLeft < 0 || dRight < 0 || dLeft != dRight) return -1;
    return 1+dLeft; // It's the same as dRight
}