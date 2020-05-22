class BubRec {

    Integer arryMem[];
    int n;

    BubRec(Integer ary[]) {
        arryMem = new Integer[ary.length];
        for (int i = 0; i <= ary.length - 1; i++) {
            arryMem[i] = ary[i];
        }
        n = arryMem.length;
    }

    // ...

}