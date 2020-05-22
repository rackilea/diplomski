class NonPasswordShowingStringBuilder extends ReflectionToStringBuilder
{
    protected boolean accept(Field f) {
         return super.accept(f) && !f.getName().equals("password");
    }

    public NonPasswordShowingStringBuilder(Object o) { super(o); }
}