package test;
public class BeanTest implements java.io.Serializable {
    private String bHours = "ten";
    private String RICK = "me";
    private String Joe = "hello";

    public BeanTest(){
    }
    public void setbHours(String bHours){
       this.bHours = bHours;
    }
    public String getbHours(){
       return bHours;
    }
    public void setRICK(String str){
                         RICK = str;
    }
    public String getRICK(){
       return RICK;
    }
    public void setJoe(String str){
                         Joe = str;
    }
    public String getJoe(){
       return Joe;
    }
}