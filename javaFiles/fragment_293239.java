boolean contains(array, value) {
    for (int i = 0; i < array.length; i++) {
        if (value == array[i]) {
            return true;
        }
    }  
    return false;
}


if (!contains(array, numberIn)) {
    System.out.println("WRONG!!!!!");
}