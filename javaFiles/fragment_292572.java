public static String betterSolution(int a, int b, int c, int d){
    while( c > a || d > b){
        if(c > d){
            if (d == 0) break; // otherwise, it does not terminate!
            c = c-d;
        }else{
            if (c == 0) break; // otherwise, it does not terminate!
            d = d-c;
        }
    }
    if( c == a &&  d == b){
        return "Able to generate";
    }else{
        return "Not able to generate";
    }
}