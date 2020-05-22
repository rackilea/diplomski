enum Hardware
{
    USB2("external low speed"),
    PCI("embedded"),
    USB3("external high speed");

    private String val;

    private Hardware(String val){
        this.val = val;
    }

    public String toString(){
        return val;
    }
}