public class StackOverflow {
            static String blackListInput = "*[]#$";
            static char c[] = {'*','[',']','#','$'};
            public static boolean isBlackList(String val) {
                if("".equals(val) || val == null) {
                    return false;
                }
                if(val.contains(Character.toString(c[0]))) {
                    return true;
                }
                if(val.contains(Character.toString(c[1]))) {
                    return true;
                }
                if(val.contains(Character.toString(c[2]))) {
                    return true;
                }
                if(val.contains(Character.toString(c[3]))) {
                    return true;
                }
                if(val.contains(Character.toString(c[4]))) {
                    return true;
                }
                return false;
            }

            public static boolean  cleanseInput(String val) {
                if(isBlackList(val))
                    return true;
                return false;
            }
            public static void main(String[] args) {
                boolean b = cleanseInput("*");
                System.out.println(b);
            }
        }