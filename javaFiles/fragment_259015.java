int[] values = new int[list.size()];
int[] indices = new int[list.size()];
int pt = 0;

for (Pair p: list) {
    values[pt] = p.value;
    indices[pt] = p.index;
    pt += 1;
}