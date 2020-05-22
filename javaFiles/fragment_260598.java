String output = "";
if (base == 2){
    while(given != 0){
        remainder = given % base;
        given /= base;
        output = remainder + output;
    }
    System.out.println(output);
}