import java.util.Arrays;
import java.util.HashMap;

public class FrequencyPrint {
    public static void main(String[] args) {
        String s = "ccrrcdcffcghijk";
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                int value = hashMap.get(s.charAt(i));
                hashMap.put(s.charAt(i), ++value);
            } else {
                hashMap.put(s.charAt(i), 1);
            }
        }

        Character keys[] = Arrays.copyOf(hashMap.keySet().toArray(), hashMap
                .keySet().toArray().length, Character[].class);
        Integer values[] = Arrays.copyOf(hashMap.values().toArray(), hashMap
                .values().toArray().length, Integer[].class);


        for (int i = 0; i < keys.length; i++) {
            int x = FrequencyPrint.findmax(values);
            for (int j = 0; j < values[x]; j++) {
                System.out.print(keys[x]);
            }
            values[x] = 0;
        }

    }

    public static int findmax(Integer values[]) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > values[max]) {
                max = i;
            }
        }
        return max;
    }
}