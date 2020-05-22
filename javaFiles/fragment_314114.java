public class HelloWorld{

     public static void main(String []args){
        Map<String,String> map = new HashMap<String,String>();
        map.put("\u2018","'");
        map.put("\u2019","'");
        map.put("\u201C","\"");
        map.put("\u201D","\"");



        List<String> toRemove = Arrays.asList("\u2018","\u2019","\u201C","\u201D");

        String text = "KURT’X45T”YUZXC";


        text=map.entrySet().stream()
                .map(e -> (Function<String,String>) s ->  s.replaceAll(e.getKey(), e.getValue()))
                .reduce(Function.identity(), Function::andThen)
                .apply(text);
        System.out.println(text);

       // or you can even do like this

        text=map.entrySet().stream()
                .map(e -> (Function<String,String>) s ->  s.replaceAll(e.getKey(), e.getValue()))
                .reduce(Function.identity(),(a, b) -> a.andThen(b))
                .apply(text);
        System.out.println(text);


     }
}