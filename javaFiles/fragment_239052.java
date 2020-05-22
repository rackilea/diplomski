void draw() {

    // [...]

    if (actPendle == 1) {

        e += add;
        if(e > 1){
            add *= -1;
        } else if (e < 0) {
            add *= -1;
            actPendle = 2;
        }
    }

    if (actPendle == 2) {

        e2 -= add2;
        if(e2 < -1){
            add2 *= -1;
        } else if (e2 > 0) {
            add2 *= -1;
            actPendle = 1;
        }
    }
}