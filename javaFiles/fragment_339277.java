if (first) {
    greatest = current;
    first = false;
    initialized = true;
}
else if (current > greatest) {
    greatest = current;
}