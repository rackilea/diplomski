public class MultiClass {
    final String str;

    public MultiClass(boolean flag) {
        if (flag) {
            this.str = "you are in the second class";
        } else {
            this.str = "you are in the first class";
        }
    }
}