for (int k = 0; k < arrayBin.length; k++) {
    StringBuilder sb = new StringBuilder(arrayBin[k].length());
    for (int l = 0; l < arrayBin[k].length(); l++) {
        if (arrayBin[k].charAt(l) == '1') {
            sb.append ('x');
        } else {
            sb.append (' ');            
        }
    }
    arrayBin[k] = sb.toString();
    System.out.println(arrayBin[k]);
}