public class MathValue<T extends Object> {

    public static MathValue<String> from(String s) {
        MathValue<String> mv = new MathValue<String>();

        mv.setValue(s);
        mv.setIsOperand(true);
        return mv;
    }

     public static MathValue<Integer> from(Integer s) {
        MathValue<Integer> mv = new MathValue<Integer>();

        mv.setValue(i);
        mv.setIsOperand(false);
        return mv;
    }

    // Rest of your class below
}