public class SomeObjectConverter implements Converter<String, SomeObject> {

    @Override
    public SomeObject from(final String s) {
        return s == null ? null : new SomeObject(s);
    }

    @Override
    public String to(final SomeObject s) {
        return s == null ? null : s.getFieldsThatsString();
    }

    ...
}