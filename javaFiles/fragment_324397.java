public class Employee extends Person implements Serializable {

    private String username;
    private String password;
    private String date;
    private int hpw;
    private int recordSold;
    private float hourPay;

    public Employee() {}

    public Employee(String u, String n, String s, String p, int i, int h, String d, int rSold, float hPay) {
        super(id, name, surname);
        this.username = u;
        this.password = p;
        this.hpw = h;
        this.date = d;
        this.recordSold = rSold;
        this.hourPay = hPay;
    }
}