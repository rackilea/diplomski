import java.text.DecimalFormat;
public class Rounder {
    public static void main(String[] args) {
        double value = 0.0000037d;
        // size to the maximum number of digits you'd like to show
        // used to avoid representing the number using scientific notation
        // when converting to string
        DecimalFormat maxDigitsFormatter = new DecimalFormat("#.###################");
        StringBuilder pattern = new StringBuilder().append("0.00");
        if(value < 0.01d){
            String s = maxDigitsFormatter.format(value);
            int i = s.indexOf(".") + 3;
            while(i < s.length()-1){
                pattern.append("0");
                i++;
            }
        }
        DecimalFormat df = new DecimalFormat(pattern.toString());
        System.out.println("value           = " + value);
        System.out.println("formatted value = " + maxDigitsFormatter.format(value));
        System.out.println("pattern         = " + pattern);
        System.out.println("rounded         = " + df.format(value));
    }
}