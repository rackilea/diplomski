public CounterFJ(List<T> list, T test, int start, int end, int factor) {
        _list = list;
        _threadId = Thread.currentThread().getId(); //added
        _test = test;
        _start = start;
        _end = end;
        _branchFactor = factor;
}