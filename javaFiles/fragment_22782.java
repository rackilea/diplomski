static MyObject[] fromArrayPointer(Pointer pointer, int numberResults) {
    MyObject[] arr = new MyObject[numberResults];
    int offset = 0;
    for (int i = 0; i < numberResults; i++) {
        arr[i] = fromPointer(pointer, offset);
        offset += <size of structure>;
    }
    return arr;
}

static MyObject fromPointer(Pointer pointer, int offset) {  
    MyObject inst = new MyObject();
    inst.info1= pointer.getString(offset);
    offset += 1025;
    inst.sizeF = pointer.getNativeLong(offset);
    offset += 4; // long but 4 bytes because of machine
    inst.info2 = pointer.getString(offset);
    offset += 20;
    return inst;
}