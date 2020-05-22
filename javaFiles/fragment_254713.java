private static String salary(double sal) {

    DecimalFormat df = new DecimalFormat("###.00");

    return (df.format(sal));
 }