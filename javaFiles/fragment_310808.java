public class Laptop {

    private String modelName;
    private String motherboard;
    private String systemType;
    private int ram;
    private int cpu;
    private int hdd;

    public static void main(String[] args) {        
        Laptop laptop = new Laptop();
        laptop.setModelName("M610");
        laptop.setMotherboard("MSI");
        laptop.setSystemType("Linux");
        laptop.setRam(2048);
        laptop.setCpu(50);
        laptop.setHdd(1500);

        laptop.printResult();
    }
    public void printResult() {
        System.out.println("Model name:"  + getModelName());
        System.out.println("Motherboard:" +getModelName());
        System.out.println("System type: "+ getSystemType());
        System.out.println("RAM :" + getRam());
        System.out.println("HDD :" + getHdd());
        System.out.println("CPU :" + getCpu());
    }
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

}