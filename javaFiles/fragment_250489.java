public class ObjStore {
    public ObjStore(){
        this(false);
    }
    // Load default parameters directly into the constructor
    public ObjStore(boolean loadDefault){
        if( loadDefault ){
            defParam1 = 123; // (int) DefaultRegistrator.getDefault("ObjStore", "defParam1");
            defParam2 = 123; // (int) DefaultRegistrator.getDefault("ObjStore", "defParam2");
            defParam3 = 123; // (int) DefaultRegistrator.getDefault("ObjStore", "defParam3");
        }
    }
    public int getDefParam1() {
        return defParam1;
    }

    public int getDefParam2() {
        return defParam2;
    }

    public int getDefParam3() {
        return defParam3;
    }

    public int getParam4() {
        return param4;
    }

    public void setParam4(int param4) {
        this.param4 = param4;
    }

    public int getParam5() {
        return param5;
    }

    public void setParam5(int param5) {
        this.param5 = param5;
    }

    public int getParam6() {
        return param6;
    }

    public void setParam6(int param6) {
        this.param6 = param6;
    }

    private int defParam1;
    private int defParam2;
    private int defParam3;
    private int param4;
    private int param5;
    private int param6;
}