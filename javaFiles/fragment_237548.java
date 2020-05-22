public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            System.out.println("START");
            System.out.println(Glassfish.startGlassfishServer());
            System.out.println("RESTART");
            System.out.println(Glassfish.restrartGlassfishServer());
            System.out.println("STOP");
            System.out.println(Glassfish.stopGlassfishServer());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}