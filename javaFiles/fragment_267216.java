// You may want to make a dedicated method for this
int max = Math.max(Math.max(A, B), Math.max(C, D));
int additional;
if (max == A) {
    additional = 2;
} else if (max == B) {
    additional = 3;
} else if (max == C) {
    additional = 1;
} else if (max == D) {
    additional = 2;
} else {
    throw new IllegalStateException();
}
while (h < max + additional) {
    r.up();
    h++;
}