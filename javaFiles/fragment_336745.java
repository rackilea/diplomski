class MyDSL {

    public static Field<Integer> field(Field<String> search, String in1) {
        return field(search, DSL.val(in1));
    }

    public static Field<Integer> field(Field<String> search, Field<String> in1) {
        return DSL.field("field({0}, {1})", Integer.class, search, in1);
    }

    public static Field<Integer> field(Field<String> search, 
                                       String in1, 
                                       String in2) {
        return field(search, val(in1), val(in2));
    }

    public static Field<Integer> field(Field<String> search, 
                                       Field<String> in1, 
                                       Field<String> in2) {
        return DSL.field("field({0}, {1}, {2})", Integer.class, search, in1, in2);
    }

    // ... or, support a varargs function variant, too
}