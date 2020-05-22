public void removeElementAt(int index) throws IllegalArgumentException {

    Object temp[] = new Object[data.length - 1];
    for (int i = 0; i < temp.length; i++) {
        if (i > index){
            temp[i - 1] = data[i];
        } else {
            temp[i] = data[i];
        }
    }
    data = temp;

    if (index > data.length || index < 0) {
        throw new IllegalArgumentException();
    }
}