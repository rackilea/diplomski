public static String evenBetterSolution(int a, int b, int c, int d){
    while( c > a || d > b){
        if(c > d){
            if (d == 0) break; 
            c = c - Math.max(1, (c - a) / d) * d;
        }else{
            if (c == 0) break;
            d = d - Math.max(1, (d - b) / c) * c;
        }
    }
    if( c == a &&  d == b){
        return "Able to generate";
    }else{
        return "Not able to generate";
    }
}