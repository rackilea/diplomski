public void put(Object k, Object v) {
    if (nrElem == elems.length) {
        resize();
    }
    elems[nrElem] = new ObjectDictionary();
    elems[nrElem].key = k;
    elems[nrElem].value = v;
    ++nrElem;
}