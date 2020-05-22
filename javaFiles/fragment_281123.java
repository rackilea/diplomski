if (r.value > value) {
// or if (value < r.value) {
    r.left = insert(value, r.left);
} else {
    r.right = insert(value, r.right);
}