public @interface CustomAnnot {

    String[] author() default "me";
    String description() default "";

}