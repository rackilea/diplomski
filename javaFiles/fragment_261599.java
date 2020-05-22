public class Debug {

    public void log(String msg) {
        String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.out.println(time + " : " + msg);
    }
}