public class Sample {

    private int a;
    private boolean b;
    private String c;
    //getters and setters for fields not shown

    public String toHistoryToken(){
        return a+"/"+b+"/"+c;
    }
    public void fromHistoryToken(String token){
        String[] values=token.split("/");
        a=Integer.parseInt(values[0]);
        b=Boolean.parseBoolean(values[1]);
        c=values[2];
    }
}