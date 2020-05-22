import org.mvel2.MVEL;

    public class MVELEvalTst {

        public static void main(String[] args) {
            String name = "xxx";

            Map map = new HashMap();
            map.put("myName",name);
            Object eval = MVEL.eval("myName=='xxx'",map);
            System.out.println(eval);
        }

    }