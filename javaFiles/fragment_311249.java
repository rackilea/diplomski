public class SO12 {
        public static void main(String[] args) {
            String mystring = "[\"28, 4th Cross Road, HAL 3rd Stage, Hal, Puttappa layout, New Thippasandra, Bangalore, Karnataka 560008, Hindistan\"]";


            mystring = mystring.replace("[", "");
            mystring = mystring.replace("]", "");
            mystring = mystring.replace("\"", "");
            String[] arr = mystring.split(",");
            System.out.println(mystring + arr.length);
            for (int i = arr.length - 1; i > 0; i--) {
                String s = arr[i];
                String log = s;
                if (s.equalsIgnoreCase(" Bangalore")) {
                    log = log + "\t found";
                }else{
                    log = log + "\t not found";

                }
                System.out.println(log);

            }
        }
    }