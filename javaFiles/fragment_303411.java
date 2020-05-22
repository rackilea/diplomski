public Object get(int index) {
    if (index >= data.length || index < 0) {
        return null;
    }
    return data[index];
}