public class MySingleTon {    
    private static MySingleTon myObj;
    private String creator;
    private MySingleTon(String creator){
         this.creator = creator;
    }
    public static MySingleTon getInstance(String creator){
        if(myObj == null){
            myObj = new MySingleTon(creator);
        }
        return myObj;
    }
    public static void main(String a[]){
        MySingleTon st = MySingleTon.getInstance("DCR");
    } 
}