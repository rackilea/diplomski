public static void main(String[] args) {

    System.out.println(find_percent(100,300,100)+"%");
    System.out.println(find_percent(100,300,300)+"%");
    System.out.println(find_percent(100,300,200)+"%");
    System.out.println(find_percent(100,300,150)+"%");
    System.out.println(find_percent(100,300,250)+"%");
    System.out.println("");
    System.out.println(find_percent(20,40,20)+"%");
    System.out.println(find_percent(20,40,40)+"%");
    System.out.println(find_percent(20,40,25)+"%");
    System.out.println(find_percent(20,40,35)+"%");

}


public static double find_percent(double start,double end,double val){

    end = end- start;
    val = val - start;
    start = 0;

    return((1-(val/end))*100);
}