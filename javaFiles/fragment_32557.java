public String toPlainString() {
    if(scale==0) {
        if(intCompact!=INFLATED) {
            return Long.toString(intCompact);
        } else {
            return intVal.toString();
        }
    }
    ...
}