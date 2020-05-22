public static void nullAwareBeanCopy(Object dest, Object source) throws IllegalAccessException, InvocationTargetException {
    new BeanUtilsBean() {
        @Override
        public void copyProperty(Object dest, String name, Object value)
                throws IllegalAccessException, InvocationTargetException {
            if(value != null) {
                super.copyProperty(dest, name, value);
            }
        }
    }.copyProperties(dest, source);
}