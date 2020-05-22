// Generate list 0,1,2,...,sizeB-2 of possible step-positions 
List<Integer> steps = new ArrayList<Integer>();
for (int h = 0; h < sizeB-1; h++) {
    steps.add(h);
}

// Randomly choose sizeA-1 elements
Collections.shuffle(steps);
steps = steps.subList(0, sizeA - 1);
Collections.sort(steps);

// Build result array
int[] result = new int[sizeB];
for (int h = 0, o = 0; h < sizeB; h++) {
    result[h] = o;
    if (o < steps.size() && steps.get(o) == h) {
        o++;
    }
}