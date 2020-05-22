int ix_a = 0;
int ix_b = 0;
List<String> result = new ArrayList<String>();
while (ix_a < A.size() || ix_b < B.size()) {

    // No more elements in A => append everything from B to result
    if (ix_a == A.size()) {
        result.add(B.get(ix_b));
        ix_b++;
        continue;
    }

    // No more elements in B => append everything from A to result
    if (ix_b == B.size()) {
        result.add(A.get(ix_a));
        ix_a++;
        continue;
    } 

    // Always append the lower element and advance in that list. 
    // If both lists contain the same element, append this once and advance in both lists
    // Distinguish between levels and numbers here, levels take higher precedence.
    String a = A.get(ix_a);
    String b = B.get(ix_b);
    if (isLevel(a) && isLevel(b)) {
        if (isLowerLevel(a, b)) {
            result.add(a);
            ix_a++;
        } else if (isLowerLevel(b, a)) {
            result.add(b);
            ix_b++;
        } else {
            result.add(a);
            ix_a++;
            ix_b++;
        }
    } else if (isLevel(a)) {
        result.add(b);
        ix_b++;
    } else if (isLevel(b)) {
        result.add(a);
        ix_a++;
    } else {
        if (isLowerNumber(a, b)) {
            result.add(a);
            ix_a++;
        } else if (isLowerNumber(b, a)) {
            result.add(b);
            ix_b++;
        } else {
            result.add(a);
            ix_a++;
            ix_b++;
        }
    }
}