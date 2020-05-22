Instance p = null;
for (Instance q : instances) {
    if (q.i == i) {
        p = q;
        break;
    }
}
if (p == null)
    throw new IllegalStateException();   // It wasn't there.
// Do something with p.