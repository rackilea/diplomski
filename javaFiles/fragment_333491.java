public void fillMap(HashMap<String, Object> map, Object bean) {
    try {
        BeanInfo info = Introspector.getBeanInfo(bean.getClass());
        PropertyDescriptor[] props = info.getPropertyDescriptors();
        for (int i = 0; i < props.length; i++) {
            Method reader = props[i].getReadMethod();
            if (reader != null && !props[i].getName().equals("class")) {
                Object invoke = reader.invoke(bean, new Object[] {});
                if (invoke != null) {
                    if (!reader.getReturnType().isPrimitive()) {
                        fillMap(map, invoke);
                    } else {
                        map.put(props[i].getName(), invoke);
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}