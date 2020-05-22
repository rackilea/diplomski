private static String format(Duration d, String event) {
    long s=d.getSeconds();
    String prep=" since ";
    if(s<0) { s=-s; prep=" to "; }
    long h=s/3600, min=s/60;
    s-=min*60; min-=h*60;
    return h+" hour(s), "+min+" min, "+s+" sec"+prep+event;
}