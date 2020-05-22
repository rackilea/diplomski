public AbstractStringBuilder insert(int index, char str[], int offset,
                                    int len)
{
    if ((index < 0) || (index > length()))
        throw new StringIndexOutOfBoundsException(index);
    if ((offset < 0) || (len < 0) || (offset > str.length - len))
        throw new StringIndexOutOfBoundsException(
            "offset " + offset + ", len " + len + ", str.length " 
            + str.length);
    int newCount = count + len;
    if (newCount > value.length)
        expandCapacity(newCount);
    System.arraycopy(value, index, value, index + len, count - index);
    System.arraycopy(str, offset, value, index, len);
    count = newCount;
    return this;
}

public AbstractStringBuilder deleteCharAt(int index) {
    if ((index < 0) || (index >= count))
        throw new StringIndexOutOfBoundsException(index);
    System.arraycopy(value, index+1, value, index, count-index-1);
    count--;
    return this;
}