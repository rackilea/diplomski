public MaxHeap(int size){
        m_array = (T[])new Comparable[size];
    }
    public MaxHeap(T[] array){
        this(array.length);
        System.arraycopy(array, 0, m_array, 0, array.length);
    }