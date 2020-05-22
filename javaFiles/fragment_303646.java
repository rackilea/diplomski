boolean isHindi = false;
    for (int k = 0; k < Character.codePointCount(myString, 0, myString.length()); k++) {
        int c = myString.codePointAt(k);
        if (c >= 0x0900 && c <= 0x097F) {  //Hindi uni-codes are within this range
            isHindi = true;
            break;
        }
    }