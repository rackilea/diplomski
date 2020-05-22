// not allowed (causes a compilation error)
//                 vvvvv
public <LR extends L & R> StreamTuple(LR val) {
    this.left = val;
    this.right = val;
}