public String size(int size){
    String hrSize = "";
    double m = size/1024.0;
    DecimalFormat dec = new DecimalFormat("0.00");

    if (m > 1) {
        hrSize = dec.format(m).concat(" MB");
    } else {
        hrSize = dec.format(size).concat(" KB");
    }
    return hrSize;
}