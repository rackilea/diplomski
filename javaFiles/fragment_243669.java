int i1 = 0;
int i2 = 0;
int i3 = 0;

while (i1 < array1.size && i2 < array2.size && i3 < array3.size) {
    int next1 = array1[i1];
    int next2 = array2[i2];
    int next3 = array3[i3];

    if (next1 == next2 && next1 == next3) {
        recordMatch(next1);
        i1++;
        i2++;
        i3++;
    }
    else if (next1 < next2 && next1 < next3) {
        i1++;
    }
    else if (next2 < next1 && next2 < next3) {
        i2++;
    }
    else {
        i3++;
    }
}