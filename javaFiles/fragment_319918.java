public void sort() {
    String[] departureTimeArray = departureTime.toArray(new String[departureTime.size()]);
    String[] modeArray = mode.toArray(new String[mode.size()]);
    //here you convert the other lists to arrays

    int lenD = departureTimeArray.length;
    int j = 0;
    for(int i=0;i<lenD;i++){
        j = i;
        for(int k = i;k<lenD;k++){
            if(departureTimeArray[j].compareTo(departureTimeArray[k])>0){
                j = k;
            }
        }
        permutation(departureTimeArray, i, j);
        permutation(modeArray, i, j);
        //here do the same for other arrays
    }

    departureTime = Arrays.asList(departureTimeArray);
    mode = Arrays.asList(modeArray);
    //here convert back arrays to list
}

private void permutation(String[] array, int i, int j) {
    String tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
}