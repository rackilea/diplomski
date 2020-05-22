VectorMatrixMN m = ....

for (int i=0; i<SIZE; i++) {
    AVector row=m.getRow(i);
    double sum=row.elementSum();
    if (sum>0) {
        row.divide(sum);
    } else {
        m.setRow(i, new RepeatedElementVector(SIZE,1.0/SIZE));
    }
}