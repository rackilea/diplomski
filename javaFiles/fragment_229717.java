public class BaseHandler {


    public static void writeToFile(){
        StringWriter sw = new StringWriter();
        firstMethod(sw);
        secondMethod(sw);
        finalMethod(sw); 
    }
    private static void firstMethod(StringWriter sw){
        sw.append("Pandora's");
    }

    private static void secondMethod(StringWriter sw){
        sw.append("Box");
    }

    private static void finalMethod(StringWriter sw){
        sw.append("!");
        //sw writes value to file
        ...
    }
}