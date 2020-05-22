if (n == 1) {
    o = 0;
} else if (n == 2) {
    e = 0;
}
if (n == 3 || n == 5 || n == 7 || n == 9) {
    o++;
}
else if (n == 4 || n == 6 || n == 8 || n == 10) {
    e++;
}
else {
    System.out.println("no odd or even numbers");
}