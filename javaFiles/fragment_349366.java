public static <T> List<T> process(Class<T> beanClass) {
    List<T> rows = new ArrayList<>();
    BeanListProcessor<T> processor = new BeanListProcessor<T>(beanClass);
    ...
    return rows;
}