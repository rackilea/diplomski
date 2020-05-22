private AVLNode doubleRotateLeftRight(AVLNode rt) {
    if (getBalance(rt.left) < 0) {
        rt.left= rotateLeft(rt.left);
        return rotateRight(rt);
    } else {
        return rotateRight(rt);
    }
}

private AVLNode doubleRotateRightLeft(AVLNode rt) {
   if (getBalance(rt.right) > 0) {
        rt.right = rotateRight(rt.right);
        return rotateLeft(rt);
    } else {
        return rotateLeft(rt);
    }
}