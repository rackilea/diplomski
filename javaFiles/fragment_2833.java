public static class NameBeanConverter implements Converter<NameBean, String> {
    @Override
    public String convert(NameBean source) {
        return "[" + source.getName() + "]";
    }
}