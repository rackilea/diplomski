char[] colors = {'R', 'G', 'B', 'Y', 'W'};

void push() {
    for (int i = 0; i < 15; ++i) {
        // define a random int to pick char from array index from 0 to colors.length -1
        int idx = new Random().nextInt(colors.length);
        // push the element into stack
        stack.push(colors[idx]);
    }
}