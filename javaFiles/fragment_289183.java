public class ECSTMonitor {        
    private int aantalvakken;
    private final double voldoende = 5.5;
    private String[] vak;
    private Scanner input = new Scanner(System.in);
    private int[] ECTS;
    private double[] Cijfer;
    private int totaalECTS;

    public ECSTMonitor(int aantalvakken) {
        this.aantalvakken = aantalvakken;
        vak = new String[aantalvakken];
        ECTS = new int[aantalvakken];
        Cijfer = new double[aantalvakken];
    }