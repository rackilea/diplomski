private void copy(Object source, Object dest) {
    if(source.getClass().isArray() && dest.getClass().isArray()) {
        for(int i=0;i<Array.getLength(source); i++) {
            if(Array.get(source, i) != null && Array.get(source, i).getClass().isArray()) {
                copy(Array.get(source, i), Array.get(dest, i));
            } else {
                Array.set(dest, i, Array.get(source, i));
            }
        }
    }
}