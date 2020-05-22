public class Main {

    public static void main(String[] args) throws Exception {
        List<SuperClass> fields = Arrays.asList(new SubClass1(), new SubClass2(), new SubClass1());
        for (SuperClass field : fields) {
            System.out.println(FieldFactory.getViewFromPDField(new Context(), field));
        }
    }
}