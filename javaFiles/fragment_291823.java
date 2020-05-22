// first
return 4 * f(3);
return 4 * 3 * f(2);
return 4 * 3 * 2 * f(1);
return 4 * 3 * 2 * 1;

// second
return f(3) * 3;
return f(2) * 2 * 3;
return f(1) * 1 * 2 * 3;
return 1 * 1 * 2 * 3;