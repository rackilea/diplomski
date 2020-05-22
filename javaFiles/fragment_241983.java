void print(){
    if (!isEmpty()) {
        int i = front;
        do {
            System.out.print(" " + arr[i];
            i = ++i % arr.length;
        while (i != rear);
    }
}