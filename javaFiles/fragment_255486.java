public static int calcCost(Guard[] g, int spot){
    if(spot >= 31078657) return 0;
    else {
        for(int i = 51499; i >= 0; i--){
            if(g[i].getS() == spot && g[i].getF() <= 31078657) {
                return (g[i].getC() + calcCost(g, g[i].getF() + 1));
            }
        }
    }
    //here
    return 0; //or another desired default value
}