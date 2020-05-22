outer: while(some condition) {
    inner: while(another condition) {
        innermost: while(yet another condition) {
            if(breaking_condition) {
                break inner;
            } else if (one more breaking condition) {
                break outer;
            }
        }
    }
}