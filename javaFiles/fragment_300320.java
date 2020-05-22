class VoidExample {
    public static void main(String[] args) throws Exception {
        System.out.println(
            VoidExample.class
                .getMethod("main", String[].class)
                    .getReturnType().getName()
        );
    }
}