import java.util.*;

public class Compress {

static char START_A = "A".charAt(0);
static char START_a = "a".charAt(0);
static char START_0 = "0".charAt(0);
static long CODEMASK = ((1 << 28) - 1); //turn on lower 28 bits
static long RANDOMMASK = ((1L << 60) - 1) & ~ CODEMASK; //turn on upper 32 bits

public static void main(String[] args) {

    String[] test = new String[]{
            //"AAA0000", "SIN1500", "ABD2123", "SMS3345", "ZZZ9999",
            //"ABD2123", "ABD2123", "ABD2123", "ABD2123", "ABD2123"
            "ABD2123"
            };

    for(String t : test){
        long c = compress(t);
        long a = add_random(c);
        String output = to_output(a);
        long input = from_output(output);

        String[] new_c_r = remove_random(input);
        String u = uncompress(Long.valueOf(new_c_r[0]));

        System.out.println("Original input: " + t);
        System.out.println("    compressed: " + c);
        System.out.println("    after adding random amount: " + a);
        System.out.println("    *output: " + output);
        System.out.println("    *input: " + input);
        System.out.println("    random amount added: " + new_c_r[1]);
        System.out.println("    after removing random amount: " + new_c_r[0]);
        System.out.println("    uncompressed: " + u);
        System.out.println("-----------------------------------------------------------------");
    }

}

public static long compress(String line){ //7 character
    char a = line.charAt(0);
    char b = line.charAt(1);
    char c = line.charAt(2);
    int h = line.charAt(3) - START_0;
    int i = line.charAt(4) - START_0;
    int j = line.charAt(5) - START_0;
    int k = line.charAt(6) - START_0;

    long small_a = (long) a - START_A;
    long small_b = (long) b - START_A;
    long small_c = (long) c - START_A;
    long letters = (small_a * 26 * 26) + (small_b * 26) + small_c;
    long numbers = letters * 10000 + h * 1000 + i*100 + j*10 + k;
    return numbers;
}

public static String uncompress(long number){
    long k = number % 10;
    number /= 10;
    long j = number % 10;
    number /= 10;
    long i = number % 10;
    number /= 10;
    long h = number % 10;
    number /= 10;
    long small_c = number % 26;
    number /= 26;
    long small_b = number % 26;
    number /= 26;
    long small_a = number % 26;
    number /= 26;

    if (number != 0) throw new RuntimeException("input wasn't generated with compress()");

    long a = small_a + START_A;
    long b = small_b + START_A;
    long c = small_c + START_A;

    StringBuffer result = new StringBuffer();
    result.append((char) a).append((char) b).append((char) c).append(h).append(i).append(j).append(k);

    return result.toString();
}

public static long add_random(long number){
    return (((long) (Math.random()* Math.pow(2, 31))) << 28) + number;
}

public static String[] remove_random(long number){
    return new String[]{String.valueOf(number & CODEMASK), String.valueOf(number & RANDOMMASK)};
}

public static String to_output(long number){
    List<Character> a = new ArrayList<Character>();
    do{
        a.add(transform_out(number % 62));
        number /= 62;
    }while(number > 0);

    Collections.reverse(a);

    StringBuffer result = new StringBuffer();
    for(int i=0; i<a.size(); i++){
        Character s = (Character) a.get(i);
        result.append(s);
    }

    return result.toString();
}

public static long from_output(String string){
    long num = 0;
    for(char c : string.toCharArray()){
        num *= 62;
        num += transform_in(c);
    }
    return num;
}

public static char transform_out(long small){
    long out;

    if (small < 0 || small > 61){
        throw new RuntimeException("small should be between 0 and 61, inclusive");
    }
    if(small < 26){
        out = START_A + small;
    }else if(small < 52){
        out = START_a + (small-26);
    }else{
        out = START_0 + (small-52);
    }
    return (char) out;
}


public static long transform_in(char c){
    if(!String.valueOf(c).matches("[a-zA-Z0-9]")){ 
        throw new RuntimeException("char should be A-Z, a-z, or 0-9, inclusive");
    }
    long num = (long) c;

    long out;
    if(num >= START_A && num <= START_A+26) out = num-START_A;
    else if(num >= START_a && num <= START_a+26) out = (num-START_a) + 26;
    else if(num >= START_0 && num <= START_0+10) out = (num-START_0) + 52;
    else throw new RuntimeException("Salah, bego!");

    return out;
}}