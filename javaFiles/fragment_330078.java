if (obj == null) return;

for (int i = 0; i < size; i++) {
    if (obj.equals(set[i])) {
        set[i] = set[--size];
        break;
    }
}