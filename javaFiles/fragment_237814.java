public synchronized StringBuffer insert(int index, char str[], int offset,
                                        int len) 
{
    super.insert(index, str, offset, len);
    return this;
}

public synchronized StringBuffer deleteCharAt(int index) {
    super.deleteCharAt(index);
    return this;
}