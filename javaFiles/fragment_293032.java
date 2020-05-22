public void insertElementAt(int index, E el) throws IllegalArgumentException {

    Object temp[] = new Object[data.length + 1];
    for (int i = 0; i < data.length; i++) {
        if (i >= index){
            temp[i + 1] = data[i];
        } else {
            temp[i] = data[i];
        }
    }
    temp[index] = el;
    data = temp;

    if (index > data.length || index < 0) {
        throw new IllegalArgumentException();
    }
}