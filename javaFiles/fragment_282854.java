/**
     *
     * @author Taleb
     */
    public class Counter {
        static char[] letters;
        static int[] counts;
        public static void main(String[] args) {
            letters = new char[]{'a','a','a','a','a','a','b','b','c','c','c','d','d','d','d','d'
            ,'d','e','e','f','f','f'};
            counts = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

            for (char letter : letters) {
                counts[letter-'a']++;
            }
            for (int i = 0; i < 26; i++) {
                char currentChar =(char) ('a'+i);
                System.out.println(currentChar+" = "+counts[i]);
            }

        }
    }