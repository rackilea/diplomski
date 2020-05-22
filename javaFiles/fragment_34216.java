public class DemoCane {

    static Scanner sc = new Scanner(System.in);
    private static Cane[] cani;

    public static void main(String args[]) {
        setQuantitaCani();
        for (int i = 0; i < cani.length; i++) {
            cani[i] = new Cane();
            cani[i] = cani[i].setInfo();
            cani[i].getInfo();
        }

    }

    public static void setQuantitaCani(){
        System.out.println("Quanti cani vuoi aggiungere?");
        int nrcani = sc.nextInt();
        cani = new Cane[nrcani];
    }
}