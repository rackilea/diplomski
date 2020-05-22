public class Test1 {

    public static void main(String[] args) {
        try{
            String test = method("1");
            if(test==null){
                //do something else
            }
        }catch(Exception e){

        }

    }

    private static String method(String str) throws Exception{
            if(str.equals("1")) return null;
            else if(str.equals("2")) throw new Exception("My Exception");
            else return str;          
    }

}