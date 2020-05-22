int clauseC = 0;
for (int i : values) {
    if (i == 1) {
        w.le(C_PREIS, 1000);
        clauseC++;
    } else if (i == 2) {
        w.gt(C_PREIS, 1000).and().le(C_PREIS, 2500);
        clauseC++;
    } else if (i == 3) {
        w.gt(C_PREIS, 2500).and().le(C_PREIS, 5000);
        clauseC++;
    } else if (i == 4) {
        w.gt(C_PREIS, 5000).and().le(C_PREIS, 10000);
        clauseC++;
    } else if (i == 5) {
        w.gt(C_PREIS, 10000);
        clauseC++;
    }
}
// create one big OR(...) statement with all of the clauses pushed above
if (clauseC > 1) {
    w.or(clauseC);
}