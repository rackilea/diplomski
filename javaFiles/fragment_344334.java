import java.util.Map;
import java.util.HashMap;

public class Nums {
    private static Map<String, Integer> nums = new HashMap<String, Integer>();
    public static void main(String[] args) {
        nums.put("zero", 0);
        nums.put("one", 1);
        nums.put("two", 2);
        nums.put("three", 3);
        nums.put("four", 4);
        nums.put("five", 5);
        nums.put("six", 6);
        nums.put("seven", 7);
        nums.put("eight", 8);
        nums.put("nine", 9);
        nums.put("ten", 10);
        nums.put("eleven", 11);
        nums.put("twelve", 12);
        nums.put("thirteen", 13);
        nums.put("fourteen", 14);
        nums.put("fifteen", 15);
        nums.put("sixteen", 16);
        nums.put("seventeen", 17);
        nums.put("eighteen", 18);
        nums.put("nineteen", 19);
        nums.put("twenty", 20);
        nums.put("thirty", 30);
        nums.put("forty", 40);
        nums.put("fifty", 50);
        nums.put("sixty", 60);
        nums.put("seventy", 70);
        nums.put("eighty", 80);
        nums.put("ninety", 90);


        String input = args[0].toLowerCase();

        int pos;
        String num1, num2;
        int res1, res2;
        if((pos = input.indexOf(" plus ")) != -1) {
            num1 = input.substring(0, pos);
            num2 = input.substring(pos + 6);

            res1 = getNumber(num1);
            res2 = getNumber(num2);
            System.out.println(args[0] + "   =>   " + res1 + " + " + res2 + " = " + (res1 + res2));
        }
        else if((pos = input.indexOf(" minus ")) != -1) {
            num1 = input.substring(0, pos);
            num2 = input.substring(pos + 7);

            res1 = getNumber(num1);
            res2 = getNumber(num2);
            System.out.println(args[0] + "   =>   " + res1 + " - " + res2 + " = " + (res1 - res2));
        }
        else {
            System.out.println(args[0] + "   =>   " + getNumber(args[0]));
        }
    }

    private static int getNumber(String input) {
        String[] parts = input.split(" +");
        int number = 0;
        int mult = 1;
        String fact;

        for(int i=parts.length-1; i>=0; i--) {
            parts[i] = parts[i].toLowerCase();
            if(parts[i].equals("hundreds") || parts[i].equals("hundred")) {
                mult *= 100;
            }
            else if(parts[i].equals("thousands") || parts[i].equals("thousand")) {
                if(number >= 1000) {
                    throw new NumberFormatException("Invalid input (part " + (i + 1) + ")");
                }
                mult = 1000;
            }
            else if(parts[i].equals("millions") || parts[i].equals("million")) {
                if(number >= 1000000) {
                    throw new NumberFormatException("Invalid input (part " + (i + 1) + ")");
                }
                mult = 1000000;
            }
            else if(!nums.containsKey(parts[i])) {
                throw new NumberFormatException("Invalid input (part " + (i + 1) + ")");
            }
            else {           
                number += mult * nums.get(parts[i]);
            }
        }

        if(!nums.containsKey(parts[0])) {
            number += mult;
        }

        return number;
    }
}