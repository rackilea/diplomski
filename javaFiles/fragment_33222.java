public class Save implements Serializable
{
    private int i ; 
    private String s;
    private boolean b;
    public Save(int i, String s, boolean b)
    {
        this.i = i;
        this.s = s;
        this.b = b;
    }
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
    public boolean isB() {
        return b;
    }
    public void setB(boolean b) {
        this.b = b;
    }
}