PBClass[] listPB = { pb1, pb2, pb3, pb4};
BClass[] listB = { b1, b2, b3, b4};

public void pb1TouchingBaddy() {
    for (int i=0; i < listPB.length - 1; i+=2) {
        for (int j=0; j < listB.length; j++) {
            move(pb[i], pb[i+1], b[j]);
        }
    }
}