public void insert(int i, String s) {

    String[] newArr = new String[array.length + 1];
    for (int j = 0; j < array.length; j++) { 
        if(j < i){
           newArr[j] = array[j];
        } else if(j == i){ // '==' insted of '='
           newArr[j] = s;
        } else {
           newArr[j+1] = array[i];
        }
    }

    array = newArr;
}