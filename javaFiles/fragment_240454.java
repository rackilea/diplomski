class Demo {
    public static void main(String[] args) {
        float f = 16_777_216f;
        System.out.println(String.format("%8.0f", f));     // 16777216
        System.out.println(String.format("%8.0f", f + 1)); // 16777216 (still)
    }
}