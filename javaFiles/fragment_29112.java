public static boolean isTriple(int d1, int d2, int d3){
    if (d1 == d2 && d2 == d3){
        return true;
    }
    return false;
}   

public static boolean isStraight(int d1, int d2, int d3){
    if (d2 == d1 + 1 && d3 == d2 + 1 || d1 == d2 + 1 && d2 == d3 + 1){
        return true;
    }
    return false;
}

public static boolean isPair(int d1, int d2, int d3){
    if (d1 == d2 || d2 == d3 || d1 == d3){
        return true;
    }
    return false;
}

public static boolean isNone(int d1, int d2, int d3){
    if (!(isTriple(d1, d2, d3)|| isStraight(d1, d2, d3)|| isPair(d1, d2, d3))){
        return true;
    }
    return false;
}