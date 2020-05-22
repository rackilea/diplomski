@JsonIgnoreProperties(ignoreUnknown = true)    
public  class Info {

    private int par1;
    private int par2;
    private int par3;
    private int par4;

    //private Items items;    

    public Info() {
        // TODO Auto-generated constructor stub
    }

    public int getPar1() {
        return par1;
    }

    public void setPar1(int par1) {
        this.par1 = par1;
    }

    public int getPar2() {
        return par2;
    }

    public void setPar2(int par2) {
        this.par2 = par2;
    }

    public int getPar3() {
        return par3;
    }

    public void setPar3(int par3) {
        this.par3 = par3;
    }

    public int getPar4() {
        return par4;
    }

    public void setPar4(int par4) {
        this.par4 = par4;
    }
}