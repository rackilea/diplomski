public class Test {

    int[] array1 = { 1, 2, 3 };
    String[] array2 = { "Hello", "World" };

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("array1:\n");
        for (int i : array1)
            sb.append("    ").append(i).append('\n');

        sb.append("\narray2:\n");
        for (String s : array2)
            sb.append("    ").append(s).append('\n');

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Test());
    }
}