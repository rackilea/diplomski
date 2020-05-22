double x;
if (count==0) {
    if (y_2<y_1) {
        x=squiggle2;
    } else {
        x=squiggle2/squiggle1;
    }
} else {
    x=Sample(squiggle1);
}
int binNumber=(int)((x-a)/dx);