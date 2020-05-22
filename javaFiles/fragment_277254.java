public static void main(String[] args) {
    if (args.length > 0) {
        // exceptions handling omitted
        Class<?> clazz = Class.forName(args[0]);
        // check before casting
        if (BaseClass.class.isAssignableFrom(clazz)) {
            BaseClass instance = (BaseClass) clazz.newInstance();
            // use
        }
    }
}