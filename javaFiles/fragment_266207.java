public static List<T> getBeanList(Class<T> clazz) {

    String sql = "....";

    List<T> beanList = DBUtil.getBeanList(sql, clazz);

    return beanList;
}