public class Skip {
    public static String[] transform(String[] in) {
        int shortenLength = (in.length / 3) + ((in.length % 3 > 0) ? 1 : 0);
        int newLength = in.length - shortenLength;
        String[] out = new String[newLength];
        int outIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (i % 3 != 0) {
                out[outIndex++] = in[i];
            }
        }
        return out;
    }

    public static void main(String[] args) {
        String[] nums = {"a", "b", "c", "d", "e", "f", "g", "h", "i" };
        String[] out = transform(nums);
        System.out.println("out = " + String.join(", ", out));
    }
}