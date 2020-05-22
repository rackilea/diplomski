char j, k=0; 
    if (length > 1) {
        for (int i = 0; i < length; i++) {
            j = str2.charAt(i);
            if(i!=length-1){
                k = str2.charAt(i + 1);
            }               
            if (j == ' ') {
                str = str + j + (Character.toUpperCase(k));
                i++; //    for skip
            } else {
                str = str + j;
            }
        }
    } else {
        str = "Please enter a string.";
    }