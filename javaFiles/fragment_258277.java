public class Test {
    public static void main(String[] args) {
        // We're only checking the compilation for the moment :)
        List<List<String>> lists = null;
        List<String[]> arrays = null;

        Matrix<String> x = Matrix.fromArrays(arrays);
        Matrix<String> y = Matrix.fromLists(lists);
    }
}