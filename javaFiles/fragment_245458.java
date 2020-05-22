<T> public T[][] boxArray(Class<T> clazz, Object array) {
    int height = Array.getLength(array);
    int width = height == 0 ? 0 : Array.getLength(Array.get(array, 0));
    T[][] result = (T[][]) Array.newInstance(clazz, height, width);
    for(int i = 0; i < height; i ++) {
        Object a = Array.get(array, i);
        for(int j = 0; j < width; j++) {
            result[i][j] = (T) Array.get(a, j); 
        }
    }
    return result;
}