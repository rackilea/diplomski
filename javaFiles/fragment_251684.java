int hailstone(int i, int steps) {
    steps++;
    if(i == 1) return steps;
    if(i % 2 == 0) return hailstone(i / 2, steps);
    else return hailstone(i * 3 + 1, steps);
}

// main function
x = hailstone(num, 0);