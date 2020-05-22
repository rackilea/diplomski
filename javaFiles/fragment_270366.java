public int getMax() throws Exception {
    if (isEmpty()) {
        Exception EmptyHeapException = new EmptyHeapException();
        throw EmptyHeapException;
    } else {
        //findMax(0, 0);    //If you want to use Iteration
        for(int i=0;i<=last;i++)
            max = Math.max(h[i].key, max);//Updated Thanks Raul Guiu
        return max;
    }
}