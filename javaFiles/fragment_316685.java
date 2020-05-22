private static int computeIntersection(Rectangle rect1, Rectangle rect2){
    if (rect1.left >= rect2.right || rect2.left >= rect1.right
            || rect1.bottom >= rect2.top || rect2.bottom >= rect1.top) {
        return 0;
    } else {
        int x_overlap = Math.min(rect1.right, rect2.right) - Math.max(rect1.left, rect2.left);
        int y_overlap = Math.min(rect1.top,rect2.top) - Math.max(rect1.bottom,rect2.bottom);
        return x_overlap * y_overlap;
    }
}