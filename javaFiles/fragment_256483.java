public class Test012 {

    public static void main(String[] args) throws Exception {
        System.out.println( seconds() );
        System.out.println( seconds2() );
        System.out.println( days3() );
    }

    public static long seconds() throws Exception {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d1 = sdf.parse("1986-04-08");
        java.util.Date d2 = sdf.parse("2013-11-28");
        return ( d2.getTime() - d1.getTime() ) / 1000;
    }

    public static long seconds2() throws Exception {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d1 = sdf.parse("1986-04-08");
        java.util.Date d2 = new java.util.Date();
        return ( d2.getTime() - d1.getTime() ) / 1000;
    }

    public static long days3() throws Exception {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d1 = sdf.parse("2008-01-01");
        java.util.Date d2 = sdf.parse("2009-01-01");
        return ( d2.getTime() - d1.getTime() ) / 1000 / 60 / 60 / 24;
    }

}