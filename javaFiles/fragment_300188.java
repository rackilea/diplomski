static final String dimLabels = "ARNDCQ";

char dimChar = 'R';
int dimIndex = dimLabels.indexOf(dimChar);
if (dimIndex >= 0) {
    ... // The index is valid
} else {
    ... // The index name is invalid
}