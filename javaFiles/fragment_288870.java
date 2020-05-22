public class Classic {
    @Annotate1(location = "foo", name = "bar")
    public final Comp1 comp1 = new Comp1();

    @Annotate2(member = "blessed")
    public final Comp2 comp2 = new Comp2();

    public static void main(String[] args) {
        Class clazz = Classic.class;
        for(Field field: clazz.getDeclaredFields()){

            if(field.isAnnotationPresent(Annotate1.class)){
                Annotate1 annotate1 = field.getAnnotation(Annotate1.class);
                System.out.println(annotate1.name());
            }else if(field.isAnnotationPresent(Annotate2.class)){
                Annotate2 annotate2 = field.getAnnotation(Annotate2.class);
                System.out.println(annotate2.member());
            }
        }
    }
}