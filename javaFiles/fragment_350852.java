String[] array1 = new String[] {"Quarter", "Dime", "Nickel", "Penny"};
String[] array2 = new String[] {"Dime", "Penny", "Quarter", "Nickel"};

public boolean equalArrays(String[] array1, String[] array2) {
    if(array1.length != array2.length) {
        return false;
    }
    int matched = 0;
    for(int i = 0; i < array1.length; i++) {
        for(int j = 0; j < array2.length; j++) {
            if(array2[j].equals(array1[i])) {
                matched++;
                break;
            }
        }
    }
    return matched == array1.length;
}