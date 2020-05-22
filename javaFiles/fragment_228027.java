public V remove(Object key)
{
    int h = hashFunction(key);

    while (elementData[h] != null)
    {
        if (elementData[h].getKey() != null && elementData[h].getKey().equals(key)) // linear probing to search
        {
            V store;
            store = elementData[h].value;
            elementData[h] = REMOVED;
            size--;
            return store;
        }
        h = (h + 1) % elementData.length;
    }
    return null;
}