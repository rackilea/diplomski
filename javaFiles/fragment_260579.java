if(minValue < iValue) {
    int temp = iValue;
    char idx = list.get(minIndex).charAt(0);
    int idxValue = (int) idx;
    iValue = idxValue;
    idxValue = temp;
}