for (String number : numbers){
    if (number.length() != 0) {
        ary[j++] = Integer.parseInt(number); 
    } else {
        ary[j++] = 0; // In this case, zero is the same as "empty"
    }
}