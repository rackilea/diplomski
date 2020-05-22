class TestHomework {
    public static void main(String[] args) {
        ArrayList<Homework> list = new ArrayList<Homework>();

        // will create a homework with type Math and one page to read
        list.add(new MyMath(1,"Math"));

        // Assuming MyJava is similar to MyMath
        list.add(new MyJava(1,"Java"));


        for (Homework s : list) {

            if (s instanceof MyMath) {
            // modify the number of pages to read for the Math homework
            s.createAssignment(3);
            } else if (s instanceof MyJava) {
            // modify the number of pages to read for the Java homework
            s.createAssignment(5);
            } else {
            s.createAssignment(7);
            }
        }
    }

}